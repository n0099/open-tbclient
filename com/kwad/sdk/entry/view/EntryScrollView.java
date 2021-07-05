package com.kwad.sdk.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.entry.view.EntryViewPager;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class EntryScrollView extends com.kwad.sdk.entry.view.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f37261c;

    /* renamed from: d  reason: collision with root package name */
    public EntryViewPager f37262d;

    /* renamed from: e  reason: collision with root package name */
    public a f37263e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37264f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f37265g;

    /* loaded from: classes7.dex */
    public class a extends PagerAdapter implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EntryScrollView f37268a;

        /* renamed from: b  reason: collision with root package name */
        public List<EntryPhotoView> f37269b;

        /* renamed from: c  reason: collision with root package name */
        public List<EntryPhotoView> f37270c;

        public a(EntryScrollView entryScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entryScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37268a = entryScrollView;
            this.f37269b = new ArrayList();
            this.f37270c = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) && (obj instanceof View)) {
                viewGroup.removeView((View) obj);
                this.f37269b.add((EntryPhotoView) obj);
                this.f37270c.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37268a.f37261c.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f37268a.a(getCount(), i2) : invokeI.floatValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            EntryPhotoView entryPhotoView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
                if (this.f37269b.size() > 0) {
                    entryPhotoView = this.f37269b.remove(0);
                    entryPhotoView.l();
                } else {
                    entryPhotoView = (EntryPhotoView) View.inflate(this.f37268a.getContext(), R.layout.ksad_view_entryphoto, null);
                }
                if (this.f37268a.getItemPlayRes() > 0) {
                    entryPhotoView.setPlayBtnRes(this.f37268a.getItemPlayRes());
                }
                entryPhotoView.setAdShowStyle(this.f37268a.getAdShowStyle());
                viewGroup.addView(entryPhotoView);
                entryPhotoView.a(this.f37268a.getEnableWebp(), true);
                entryPhotoView.a(i2, ((com.kwad.sdk.entry.view.a) this.f37268a).f37302a.f36566e);
                entryPhotoView.a((AdTemplate) this.f37268a.f37261c.get(i2), ((com.kwad.sdk.entry.view.a) this.f37268a).f37302a);
                entryPhotoView.setLikeViewPos(((com.kwad.sdk.entry.view.a) this.f37268a).f37302a.f36565d);
                entryPhotoView.setOnClickListener(this.f37268a.f37265g);
                if (i2 != getCount() - 1 || this.f37268a.f37264f) {
                    entryPhotoView.setLookMoreVisible(false);
                } else {
                    entryPhotoView.setLookMoreVisible(true);
                }
                entryPhotoView.setId(i2);
                this.f37270c.add(entryPhotoView);
                return entryPhotoView;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) this.f37268a.f37262d.findViewById(i2);
                if (entryPhotoView != null) {
                    entryPhotoView.f();
                }
                for (EntryPhotoView entryPhotoView2 : this.f37270c) {
                    if (entryPhotoView2 != entryPhotoView) {
                        entryPhotoView2.g();
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryScrollView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37261c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f37265g = new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryScrollView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EntryScrollView f37267a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37267a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                    this.f37267a.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37261c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f37265g = new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryScrollView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EntryScrollView f37267a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37267a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                    this.f37267a.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
                }
            }
        };
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            EntryViewPager entryViewPager = (EntryViewPager) findViewById(R.id.ksad_entry_viewpager);
            this.f37262d = entryViewPager;
            entryViewPager.setPageMargin(ao.a(getContext(), 7.0f));
            this.f37262d.setOffscreenPageLimit(3);
        }
    }

    public float a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            return 0.4f;
        }
        return invokeII.floatValue;
    }

    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a();
        }
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f37261c.clear();
            for (AdTemplate adTemplate : ((com.kwad.sdk.entry.view.a) this).f37302a.k) {
                if (!adTemplate.needHide) {
                    this.f37261c.add(adTemplate);
                }
            }
            if (this.f37261c.size() < 3) {
                setVisibility(8);
                return false;
            }
            setVisibility(0);
            this.f37263e = new a();
            int k = com.kwad.sdk.core.config.c.k();
            boolean z = this.f37261c.size() >= k && k > 0;
            this.f37264f = z;
            if (z) {
                this.f37262d.setDragSideEnable(true);
                this.f37262d.setOnDragOpenListener(new EntryViewPager.c(this) { // from class: com.kwad.sdk.entry.view.EntryScrollView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ EntryScrollView f37266a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37266a = this;
                    }

                    @Override // com.kwad.sdk.entry.view.EntryViewPager.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int size = this.f37266a.f37261c.size() - 1;
                            View findViewById = this.f37266a.f37262d.findViewById(size);
                            EntryScrollView entryScrollView = this.f37266a;
                            entryScrollView.a((AdTemplate) entryScrollView.f37261c.get(size), size, findViewById, 4);
                        }
                    }
                });
            } else {
                this.f37262d.setDragSideEnable(false);
            }
            this.f37262d.setAdapter(this.f37263e);
            this.f37262d.setOnPageChangeListener(this.f37263e);
            return true;
        }
        return invokeV.booleanValue;
    }

    public int getAdShowStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public boolean getEnableWebp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public int getItemPlayRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0.68f;
        }
        return invokeV.floatValue;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37261c : (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.entry.view.a
    public int getSourceRightMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ao.a(getContext(), 16.0f) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onFinishInflate();
            c();
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.b, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            float ratio = getRatio();
            if (ratio != 0.0f) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) * ratio), 1073741824);
            }
            super.onMeasure(i2, i3);
        }
    }
}
