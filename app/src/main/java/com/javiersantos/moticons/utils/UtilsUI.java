package com.javiersantos.moticons.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.javiersantos.moticons.Moticon;
import com.javiersantos.moticons.R;
import com.javiersantos.moticons.activities.AboutActivity;
import com.javiersantos.moticons.adapters.MoticonAdapter;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class UtilsUI {
    public static Drawer showNavigationDrawer(final Context context, Toolbar toolbar, final MoticonAdapter moticonAdapter, final MoticonAdapter moticonPositiveAdapter, final MoticonAdapter moticonNegativeAdapter, final MoticonAdapter moticonFunnyAdapter, final MoticonAdapter moticonAnimalsAdapter, final MoticonAdapter moticonSpecialAdapter, final RecyclerView recyclerView) {
        Activity activity = (Activity) context;

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(R.drawable.header)
                .build();
        return new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withStatusBarColor(context.getResources().getColor(R.color.primary_dark))
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(context.getResources().getString(R.string.app_name)).withIcon(R.mipmap.ic_launcher),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(context.getResources().getString(R.string.action_positive)).withIcon(FontAwesome.Icon.faw_thumbs_up).withBadge("(/^▽^)/"),
                        new PrimaryDrawerItem().withName(context.getResources().getString(R.string.action_negative)).withIcon(FontAwesome.Icon.faw_thumbs_down).withBadge("(>_<)"),
                        new PrimaryDrawerItem().withName(context.getResources().getString(R.string.action_funny)).withIcon(FontAwesome.Icon.faw_child).withBadge("¯\\_(ツ)_/¯"),
                        new PrimaryDrawerItem().withName(context.getResources().getString(R.string.action_animal)).withIcon(FontAwesome.Icon.faw_paw).withBadge("∪･ω･∪"),
                        new PrimaryDrawerItem().withName(context.getResources().getString(R.string.action_special)).withIcon(FontAwesome.Icon.faw_star).withBadge("ʕ•̬͡•ʕ•̫͡•♥"),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName(context.getResources().getString(R.string.action_about)).withCheckable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int position, long id, IDrawerItem iDrawerItem) {
                        switch (position) {
                            case 0:
                                recyclerView.setAdapter(moticonAdapter);
                                break;
                            case 2:
                                recyclerView.setAdapter(moticonPositiveAdapter);
                                break;
                            case 3:
                                recyclerView.setAdapter(moticonNegativeAdapter);
                                break;
                            case 4:
                                recyclerView.setAdapter(moticonFunnyAdapter);
                                break;
                            case 5:
                                recyclerView.setAdapter(moticonAnimalsAdapter);
                                break;
                            case 6:
                                recyclerView.setAdapter(moticonSpecialAdapter);
                                break;
                            case 8:
                                context.startActivity(new Intent(context, AboutActivity.class));
                                break;
                            default:
                                break;
                        }

                        return false;
                    }
                }).build();
    }

    public static String convertCategoryToString(Context context, Moticon moticon) {
        String res = "";
        switch (moticon.getCategory()) {
            case POSITIVE:
                res = context.getResources().getString(R.string.action_positive);
                break;
            case NEGATIVE:
                res = context.getResources().getString(R.string.action_negative);
                break;
            case FUNNY:
                res = context.getResources().getString(R.string.action_funny);
                break;
            case ANIMAL:
                res = context.getResources().getString(R.string.action_animal);
                break;
            case SPECIAL:
                res = context.getResources().getString(R.string.action_special);
                break;
        }

        return res;
    }

}
