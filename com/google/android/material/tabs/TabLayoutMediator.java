package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public final class TabLayoutMediator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.Adapter adapter;
    public boolean attached;
    public final boolean autoRefresh;
    public TabLayoutOnPageChangeCallback onPageChangeCallback;
    public TabLayout.OnTabSelectedListener onTabSelectedListener;
    public RecyclerView.AdapterDataObserver pagerAdapterObserver;
    public final boolean smoothScroll;
    public final TabConfigurationStrategy tabConfigurationStrategy;
    public final TabLayout tabLayout;
    public final ViewPager2 viewPager;

    /* loaded from: classes7.dex */
    public interface TabConfigurationStrategy {
        void onConfigureTab(TabLayout.Tab tab, int i);
    }

    /* loaded from: classes7.dex */
    public class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabLayoutMediator this$0;

        public PagerAdapterObserver(TabLayoutMediator tabLayoutMediator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayoutMediator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tabLayoutMediator;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.populateTabsFromPagerAdapter();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.this$0.populateTabsFromPagerAdapter();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
                this.this$0.populateTabsFromPagerAdapter();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                this.this$0.populateTabsFromPagerAdapter();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj) == null) {
                this.this$0.populateTabsFromPagerAdapter();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048580, this, i, i2, i3) == null) {
                this.this$0.populateTabsFromPagerAdapter();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int previousScrollState;
        public int scrollState;
        public final WeakReference tabLayoutRef;

        public TabLayoutOnPageChangeCallback(TabLayout tabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tabLayoutRef = new WeakReference(tabLayout);
            reset();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            TabLayout tabLayout;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (tabLayout = (TabLayout) this.tabLayoutRef.get()) != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.scrollState;
                if (i2 != 0 && (i2 != 2 || this.previousScrollState != 0)) {
                    z = false;
                } else {
                    z = true;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i), z);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.previousScrollState = this.scrollState;
                this.scrollState = i;
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && (tabLayout = (TabLayout) this.tabLayoutRef.get()) != null) {
                boolean z2 = false;
                if (this.scrollState == 2 && this.previousScrollState != 1) {
                    z = false;
                } else {
                    z = true;
                }
                tabLayout.setScrollPosition(i, f, z, (this.scrollState == 2 && this.previousScrollState == 0) ? true : true);
            }
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.scrollState = 0;
                this.previousScrollState = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean smoothScroll;
        public final ViewPager2 viewPager;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tab) == null) {
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
            }
        }

        public ViewPagerOnTabSelectedListener(ViewPager2 viewPager2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPager2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewPager = viewPager2;
            this.smoothScroll = z;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) {
                this.viewPager.setCurrentItem(tab.getPosition(), this.smoothScroll);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabLayoutMediator(TabLayout tabLayout, ViewPager2 viewPager2, TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, true, tabConfigurationStrategy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tabLayout, viewPager2, tabConfigurationStrategy};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TabLayout) objArr2[0], (ViewPager2) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (TabConfigurationStrategy) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabLayoutMediator(TabLayout tabLayout, ViewPager2 viewPager2, boolean z, TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, z, true, tabConfigurationStrategy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tabLayout, viewPager2, Boolean.valueOf(z), tabConfigurationStrategy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TabLayout) objArr2[0], (ViewPager2) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), (TabConfigurationStrategy) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public TabLayoutMediator(TabLayout tabLayout, ViewPager2 viewPager2, boolean z, boolean z2, TabConfigurationStrategy tabConfigurationStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tabLayout, viewPager2, Boolean.valueOf(z), Boolean.valueOf(z2), tabConfigurationStrategy};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.tabLayout = tabLayout;
        this.viewPager = viewPager2;
        this.autoRefresh = z;
        this.smoothScroll = z2;
        this.tabConfigurationStrategy = tabConfigurationStrategy;
    }

    public void attach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.attached) {
                RecyclerView.Adapter adapter = this.viewPager.getAdapter();
                this.adapter = adapter;
                if (adapter != null) {
                    this.attached = true;
                    TabLayoutOnPageChangeCallback tabLayoutOnPageChangeCallback = new TabLayoutOnPageChangeCallback(this.tabLayout);
                    this.onPageChangeCallback = tabLayoutOnPageChangeCallback;
                    this.viewPager.registerOnPageChangeCallback(tabLayoutOnPageChangeCallback);
                    ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(this.viewPager, this.smoothScroll);
                    this.onTabSelectedListener = viewPagerOnTabSelectedListener;
                    this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) viewPagerOnTabSelectedListener);
                    if (this.autoRefresh) {
                        PagerAdapterObserver pagerAdapterObserver = new PagerAdapterObserver(this);
                        this.pagerAdapterObserver = pagerAdapterObserver;
                        this.adapter.registerAdapterDataObserver(pagerAdapterObserver);
                    }
                    populateTabsFromPagerAdapter();
                    this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0.0f, true);
                    return;
                }
                throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
            }
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
    }

    public void detach() {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.autoRefresh && (adapter = this.adapter) != null) {
                adapter.unregisterAdapterDataObserver(this.pagerAdapterObserver);
                this.pagerAdapterObserver = null;
            }
            this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
            this.viewPager.unregisterOnPageChangeCallback(this.onPageChangeCallback);
            this.onTabSelectedListener = null;
            this.onPageChangeCallback = null;
            this.adapter = null;
            this.attached = false;
        }
    }

    public void populateTabsFromPagerAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.tabLayout.removeAllTabs();
            RecyclerView.Adapter adapter = this.adapter;
            if (adapter != null) {
                int itemCount = adapter.getItemCount();
                for (int i = 0; i < itemCount; i++) {
                    TabLayout.Tab newTab = this.tabLayout.newTab();
                    this.tabConfigurationStrategy.onConfigureTab(newTab, i);
                    this.tabLayout.addTab(newTab, false);
                }
                if (itemCount > 0) {
                    int min = Math.min(this.viewPager.getCurrentItem(), this.tabLayout.getTabCount() - 1);
                    if (min != this.tabLayout.getSelectedTabPosition()) {
                        TabLayout tabLayout = this.tabLayout;
                        tabLayout.selectTab(tabLayout.getTabAt(min));
                    }
                }
            }
        }
    }
}
