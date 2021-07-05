package com.kwad.sdk.feed.a.a.b;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.a.a;
import com.kwad.sdk.feed.detail.FeedSlideParam;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f37316b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37317c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f37318d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f37319e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f37320f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f37321g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0448a f37322h;

    /* renamed from: com.kwad.sdk.feed.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0449a implements a.InterfaceC0448a, ap.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f37323a;

        /* renamed from: b  reason: collision with root package name */
        public final int f37324b;

        public C0449a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37324b = 100;
            this.f37323a = new WeakReference<>(aVar);
        }

        @Override // com.kwad.sdk.feed.a.a.InterfaceC0448a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                com.kwad.sdk.core.d.a.a("FeedHomeItemClickPresenter", "position=" + i2);
                a aVar = this.f37323a.get();
                if (aVar == null || aVar.f37320f == null) {
                    return;
                }
                aVar.f37320f.k();
                if (aVar.f37321g == null) {
                    aVar.f37321g = new ap(this);
                }
                Message obtain = Message.obtain(aVar.f37321g);
                obtain.what = 100;
                obtain.arg1 = i2;
                aVar.f37321g.sendMessageDelayed(obtain, 100L);
            }
        }

        @Override // com.kwad.sdk.utils.ap.a
        public void a(Message message) {
            a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && (aVar = this.f37323a.get()) != null && message.what == 100) {
                aVar.f37319e.scrollToPosition(message.arg1);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void e() {
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (sceneImpl = ((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i).mAdScene) == null) {
            return;
        }
        com.kwad.sdk.feed.a.a.a().a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38570f.g());
        com.kwad.sdk.feed.a.a.a().f();
        com.kwad.sdk.feed.a.a.a().a(f());
        FeedSlideParam feedSlideParam = new FeedSlideParam();
        feedSlideParam.mEntryScene = sceneImpl.entryScene;
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a;
        feedSlideParam.mSelectedPosition = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f38572h;
        com.kwad.sdk.feed.detail.a.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f38568d, feedSlideParam);
    }

    private a.InterfaceC0448a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.f37322h == null) {
                this.f37322h = new C0449a(this);
            }
            return this.f37322h;
        }
        return (a.InterfaceC0448a) invokeV.objValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.core.report.e.b((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i, 1);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, MODEL>, com.kwad.sdk.lib.b.c<?, com.kwad.sdk.core.response.model.AdTemplate> */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a;
            this.f37318d = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).f38573i;
            this.f37319e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f38569e;
            this.f37320f = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f38570f;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            if (this.f37322h != null) {
                com.kwad.sdk.feed.a.a.a().b(this.f37322h);
            }
            Handler handler = this.f37321g;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f37316b = (ImageView) b(R.id.ksad_feed_item_cover);
            this.f37317c = (TextView) b(R.id.ksad_feed_item_photo_desc);
            this.f37316b.setOnClickListener(this);
            this.f37317c.setOnClickListener(this);
            l().setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            if (this.f37322h != null) {
                com.kwad.sdk.feed.a.a.a().b(this.f37322h);
            }
            Handler handler = this.f37321g;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdTemplate adTemplate;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || ao.a()) {
            return;
        }
        if (view == this.f37316b) {
            if (com.kwad.sdk.core.response.b.c.c(this.f37318d)) {
                adTemplate = this.f37318d;
                i2 = 83;
                com.kwad.sdk.core.report.b.d(adTemplate, i2);
            }
            e();
            g();
        } else if (view == this.f37317c) {
            if (com.kwad.sdk.core.response.b.c.c(this.f37318d)) {
                adTemplate = this.f37318d;
                i2 = 24;
                com.kwad.sdk.core.report.b.d(adTemplate, i2);
            }
            e();
            g();
        } else {
            if (com.kwad.sdk.core.response.b.c.c(this.f37318d)) {
                adTemplate = this.f37318d;
                i2 = 79;
                com.kwad.sdk.core.report.b.d(adTemplate, i2);
            }
            e();
            g();
        }
    }
}
