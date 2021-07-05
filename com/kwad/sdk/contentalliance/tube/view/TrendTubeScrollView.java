package com.kwad.sdk.contentalliance.tube.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.model.TubeProfile;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class TrendTubeScrollView extends com.kwad.sdk.widget.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TubeProfile f35818a;

    /* renamed from: b  reason: collision with root package name */
    public a f35819b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f35820c;

    /* renamed from: d  reason: collision with root package name */
    public TrendTubeEpisodeViewPager f35821d;

    /* renamed from: e  reason: collision with root package name */
    public b f35822e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f35823f;

    /* loaded from: classes7.dex */
    public interface a {
        void a(AdTemplate adTemplate, int i2, View view);
    }

    /* loaded from: classes7.dex */
    public class b extends PagerAdapter implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TrendTubeScrollView f35825a;

        /* renamed from: b  reason: collision with root package name */
        public List<EpisodePhotoView> f35826b;

        /* renamed from: c  reason: collision with root package name */
        public List<EpisodePhotoView> f35827c;

        public b(TrendTubeScrollView trendTubeScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {trendTubeScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35825a = trendTubeScrollView;
            this.f35826b = new ArrayList();
            this.f35827c = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) && (obj instanceof View)) {
                viewGroup.removeView((View) obj);
                this.f35826b.add((EpisodePhotoView) obj);
                this.f35827c.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35825a.f35820c.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f35825a.a(getCount(), i2) : invokeI.floatValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            EpisodePhotoView episodePhotoView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
                if (this.f35826b.size() > 0) {
                    episodePhotoView = this.f35826b.remove(0);
                    episodePhotoView.l();
                } else {
                    episodePhotoView = (EpisodePhotoView) View.inflate(this.f35825a.getContext(), R.layout.ksad_tube_trend_scroll_view_episode_photo, null);
                }
                viewGroup.addView(episodePhotoView);
                episodePhotoView.a(i2, this.f35825a.f35818a.tubeInfo.tubeId);
                episodePhotoView.setTemplateData((AdTemplate) this.f35825a.f35820c.get(i2));
                episodePhotoView.setOnClickListener(this.f35825a.f35823f);
                if (i2 < 5 || i2 != getCount() - 1 || this.f35825a.f35818a.tubeInfo.totalEpisodeCount <= 6) {
                    episodePhotoView.setLookMoreVisibility(false);
                } else {
                    episodePhotoView.setLookMoreVisibility(true);
                }
                episodePhotoView.setId(i2);
                this.f35827c.add(episodePhotoView);
                return episodePhotoView;
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
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendTubeScrollView(Context context) {
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
        this.f35820c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35823f = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TrendTubeScrollView f35824a;

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
                this.f35824a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    EpisodePhotoView episodePhotoView = (EpisodePhotoView) view;
                    this.f35824a.a(episodePhotoView.getTemplateData(), episodePhotoView.getPosition(), view);
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendTubeScrollView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f35820c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35823f = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TrendTubeScrollView f35824a;

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
                this.f35824a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    EpisodePhotoView episodePhotoView = (EpisodePhotoView) view;
                    this.f35824a.a(episodePhotoView.getTemplateData(), episodePhotoView.getPosition(), view);
                }
            }
        };
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            TrendTubeEpisodeViewPager trendTubeEpisodeViewPager = (TrendTubeEpisodeViewPager) findViewById(R.id.ksad_tube_trend_item_viewpager);
            this.f35821d = trendTubeEpisodeViewPager;
            trendTubeEpisodeViewPager.setPageMargin(ao.a(getContext(), 4.0f));
            this.f35821d.setOffscreenPageLimit(3);
        }
    }

    public float a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            return 0.29f;
        }
        return invokeII.floatValue;
    }

    @Override // com.kwad.sdk.widget.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a();
        }
    }

    public void a(TubeProfile tubeProfile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tubeProfile) == null) {
            this.f35818a = tubeProfile;
            if (tubeProfile == null) {
                removeAllViews();
                return;
            }
            this.f35820c.clear();
            Iterator<AdTemplate> it = this.f35818a.adTemplateList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                this.f35820c.add(it.next());
                i2++;
                if (i2 == 6) {
                    break;
                }
            }
            setVisibility(0);
            b bVar = new b();
            this.f35822e = bVar;
            this.f35821d.setAdapter(bVar);
            this.f35821d.setOnPageChangeListener(this.f35822e);
        }
    }

    public void a(AdTemplate adTemplate, int i2, View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048579, this, adTemplate, i2, view) == null) || (aVar = this.f35819b) == null) {
            return;
        }
        aVar.a(adTemplate, i2, view);
    }

    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0.38f;
        }
        return invokeV.floatValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onFinishInflate();
            b();
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.b, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            float ratio = getRatio();
            if (ratio != 0.0f) {
                int size = View.MeasureSpec.getSize(i2);
                com.kwad.sdk.core.d.a.a("TrendTubeScrollView", "ratio = " + ratio + " widthSize=" + size);
                i3 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * ratio), 1073741824);
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setEpisodeItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f35819b = aVar;
        }
    }
}
