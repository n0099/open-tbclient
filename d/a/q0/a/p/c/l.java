package d.a.q0.a.p.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class l implements d.a.q0.a.p.d.x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f49893e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<MediaModel> f49894f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f49895g;

        /* renamed from: h  reason: collision with root package name */
        public String f49896h;

        /* renamed from: i  reason: collision with root package name */
        public d.a.q0.a.i1.d.d.d f49897i;
        public HandlerC0905b j;
        public a k;

        /* loaded from: classes8.dex */
        public class a extends d.a.q0.a.g1.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public HandlerC0905b f49898e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f49899f;

            public a(b bVar, HandlerC0905b handlerC0905b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, handlerC0905b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49899f = bVar;
                this.f49898e = handlerC0905b;
            }

            @Override // d.a.q0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                    if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                        if (this.f49898e.f49901b != null && this.f49898e.f49901b.isShowing()) {
                            this.f49898e.f49901b.cancel();
                            this.f49898e.f49901b = null;
                        }
                        HandlerC0905b handlerC0905b = this.f49898e;
                        if (handlerC0905b != null) {
                            handlerC0905b.removeMessages(1);
                            this.f49898e.removeMessages(2);
                            this.f49898e = null;
                        }
                        this.f49899f.f();
                    }
                }
            }
        }

        /* renamed from: d.a.q0.a.p.c.l$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class HandlerC0905b extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<Context> f49900a;

            /* renamed from: b  reason: collision with root package name */
            public Dialog f49901b;

            public /* synthetic */ HandlerC0905b(Context context, a aVar) {
                this(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Dialog dialog;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    int i2 = message.what;
                    if (i2 != 1) {
                        if (i2 == 2 && (dialog = this.f49901b) != null && dialog.isShowing()) {
                            Context context = this.f49900a.get();
                            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                this.f49901b.cancel();
                            }
                            this.f49901b = null;
                            return;
                        }
                        return;
                    }
                    Context context2 = this.f49900a.get();
                    if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                        return;
                    }
                    Dialog dialog2 = new Dialog(this.f49900a.get(), d.a.q0.a.i.SwanAppCompressDialog);
                    this.f49901b = dialog2;
                    dialog2.setContentView(d.a.q0.a.g.swanapp_progress_dialog);
                    this.f49901b.findViewById(d.a.q0.a.f.layer_night).setVisibility(d.a.q0.a.c1.a.H().a() ? 0 : 8);
                    this.f49901b.setCancelable(false);
                    this.f49901b.show();
                }
            }

            public HandlerC0905b(Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49900a = new WeakReference<>(context);
            }
        }

        public b(Context context, Bundle bundle, d.a.q0.a.i1.d.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bundle, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49893e = context;
            this.f49894f = bundle.getParcelableArrayList("mediaModels");
            d.a.q0.a.v2.v.g(bundle, "swanAppId");
            this.f49895g = d.a.q0.a.v2.v.c(bundle, "compressed", false);
            this.f49896h = d.a.q0.a.v2.v.g(bundle, "swanTmpPath");
            this.f49897i = dVar;
            this.j = new HandlerC0905b(context, null);
        }

        public final void b(MediaModel mediaModel, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, mediaModel, i2) == null) || mediaModel == null) {
                return;
            }
            if (d.a.q0.a.i1.d.c.c.f48797a) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File l = d.a.q0.a.v2.u.l(this.f49896h, file.getName());
            if (l == null) {
                return;
            }
            mediaModel.setTempPath(l.getAbsolutePath());
            d.a.q0.a.v2.u.n(file, l, i2);
            mediaModel.setSize(l.length());
        }

        public final void c(VideoModel videoModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoModel) == null) || videoModel == null) {
                return;
            }
            if (d.a.q0.a.i1.d.c.c.f48797a) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File l = d.a.q0.a.v2.u.l(this.f49896h, new File(videoModel.getPath()).getName());
            if (l == null) {
                return;
            }
            d.a.q0.t.d.f(new File(videoModel.getPath()), l);
            videoModel.setTempPath(l.getPath());
            videoModel.setSize(l.length());
        }

        public final void d(MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaModel) == null) || mediaModel == null) {
                return;
            }
            File file = new File(mediaModel.getPath());
            File l = d.a.q0.a.v2.u.l(this.f49896h, file.getName());
            if (l == null || !l.exists() || d.a.q0.t.d.f(file, l) == 0) {
                return;
            }
            mediaModel.setTempPath(l.getPath());
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.k = new a(this, this.j);
                d.a.q0.a.c1.a.b().registerActivityLifecycleCallbacks(this.k);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.k == null) {
                return;
            }
            d.a.q0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.k);
            this.k = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                HandlerC0905b handlerC0905b = this.j;
                if (handlerC0905b != null) {
                    handlerC0905b.sendEmptyMessage(1);
                }
                if (this.f49895g) {
                    Iterator<MediaModel> it = this.f49894f.iterator();
                    while (it.hasNext()) {
                        MediaModel next = it.next();
                        if (next != null) {
                            if (next instanceof ImageModel) {
                                if (TextUtils.equals(d.a.q0.t.d.s(next.getPath()), "gif")) {
                                    d(next);
                                } else {
                                    b(next, 20);
                                }
                            } else if (next instanceof VideoModel) {
                                c((VideoModel) next);
                            }
                        }
                    }
                } else {
                    Iterator<MediaModel> it2 = this.f49894f.iterator();
                    while (it2.hasNext()) {
                        MediaModel next2 = it2.next();
                        if (next2 != null) {
                            if (next2 instanceof ImageModel) {
                                b(next2, 100);
                            } else {
                                d(next2);
                            }
                        }
                    }
                }
                HandlerC0905b handlerC0905b2 = this.j;
                if (handlerC0905b2 != null) {
                    handlerC0905b2.sendEmptyMessage(2);
                }
                d.a.q0.a.i1.d.d.d dVar = this.f49897i;
                if (dVar != null) {
                    dVar.a(true, null, this.f49894f);
                }
                f();
            }
        }
    }

    public l() {
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

    @Override // d.a.q0.a.p.d.x
    public void a(Activity activity, Bundle bundle, d.a.q0.a.i1.d.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bundle, dVar) == null) {
            d.a.q0.a.v2.q.j(new b(activity, bundle, dVar), "main process compress files");
        }
    }
}
