package com.kwad.sdk.lib.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.a.c;
import com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer;
/* loaded from: classes5.dex */
public class NestedScrollViewPager extends a implements CustomAppBarFlingConsumer {
    public NestedScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public NestedScrollViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        PagerAdapter adapter = getAdapter();
        if (adapter instanceof com.kwad.sdk.lib.widget.viewpager.tabstrip.a) {
            KsFragment a2 = ((com.kwad.sdk.lib.widget.viewpager.tabstrip.a) adapter).a();
            if (a2 instanceof c) {
                ((c) a2).i().stopNestedScroll(1);
            }
        }
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void consumeAppBarFling(int i, int i2) {
        PagerAdapter adapter = getAdapter();
        if (adapter instanceof com.kwad.sdk.lib.widget.viewpager.tabstrip.a) {
            KsFragment a2 = ((com.kwad.sdk.lib.widget.viewpager.tabstrip.a) adapter).a();
            if (a2 instanceof c) {
                ((c) a2).i().scrollBy(i, i2);
            }
        }
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void onAppBarTouchDown() {
        a();
    }
}
