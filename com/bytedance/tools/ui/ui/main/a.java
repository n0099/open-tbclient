package com.bytedance.tools.ui.ui.main;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tieba.R;
import com.bytedance.tools.ui.ui.b;
import com.bytedance.tools.ui.ui.c;
/* loaded from: classes9.dex */
public class a extends FragmentPagerAdapter {
    @StringRes
    public static final int[] b = {R.string.obfuscated_res_0x7f0f15ea, R.string.obfuscated_res_0x7f0f15eb, R.string.obfuscated_res_0x7f0f15ec};
    public final Context a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 3;
    }

    public a(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.a = context;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return new c();
            }
            return new b();
        }
        return new com.bytedance.tools.ui.ui.a();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int i) {
        return this.a.getResources().getString(b[i]);
    }
}
