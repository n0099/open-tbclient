package d.a.m0.a.p.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class l implements d.a.m0.a.p.d.x {

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Context f47747e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<MediaModel> f47748f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f47749g;

        /* renamed from: h  reason: collision with root package name */
        public String f47750h;

        /* renamed from: i  reason: collision with root package name */
        public d.a.m0.a.i1.d.d.d f47751i;
        public HandlerC0845b j;
        public a k;

        /* loaded from: classes2.dex */
        public class a extends d.a.m0.a.g1.a {

            /* renamed from: e  reason: collision with root package name */
            public HandlerC0845b f47752e;

            public a(HandlerC0845b handlerC0845b) {
                this.f47752e = handlerC0845b;
            }

            @Override // d.a.m0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                    if (this.f47752e.f47755b != null && this.f47752e.f47755b.isShowing()) {
                        this.f47752e.f47755b.cancel();
                        this.f47752e.f47755b = null;
                    }
                    HandlerC0845b handlerC0845b = this.f47752e;
                    if (handlerC0845b != null) {
                        handlerC0845b.removeMessages(1);
                        this.f47752e.removeMessages(2);
                        this.f47752e = null;
                    }
                    b.this.f();
                }
            }
        }

        /* renamed from: d.a.m0.a.p.c.l$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class HandlerC0845b extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<Context> f47754a;

            /* renamed from: b  reason: collision with root package name */
            public Dialog f47755b;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Dialog dialog;
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 == 2 && (dialog = this.f47755b) != null && dialog.isShowing()) {
                        Context context = this.f47754a.get();
                        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                            this.f47755b.cancel();
                        }
                        this.f47755b = null;
                        return;
                    }
                    return;
                }
                Context context2 = this.f47754a.get();
                if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                    return;
                }
                Dialog dialog2 = new Dialog(this.f47754a.get(), d.a.m0.a.i.SwanAppCompressDialog);
                this.f47755b = dialog2;
                dialog2.setContentView(d.a.m0.a.g.swanapp_progress_dialog);
                this.f47755b.findViewById(d.a.m0.a.f.layer_night).setVisibility(d.a.m0.a.c1.a.H().a() ? 0 : 8);
                this.f47755b.setCancelable(false);
                this.f47755b.show();
            }

            public HandlerC0845b(Context context) {
                this.f47754a = new WeakReference<>(context);
            }
        }

        public b(Context context, Bundle bundle, d.a.m0.a.i1.d.d.d dVar) {
            this.f47747e = context;
            this.f47748f = bundle.getParcelableArrayList("mediaModels");
            d.a.m0.a.v2.v.g(bundle, "swanAppId");
            this.f47749g = d.a.m0.a.v2.v.c(bundle, "compressed", false);
            this.f47750h = d.a.m0.a.v2.v.g(bundle, "swanTmpPath");
            this.f47751i = dVar;
            this.j = new HandlerC0845b(context);
        }

        public final void b(MediaModel mediaModel, int i2) {
            if (mediaModel == null) {
                return;
            }
            if (d.a.m0.a.i1.d.c.c.f46647a) {
                Log.d("CompressTask", "compressImg : " + mediaModel.b());
            }
            File file = new File(mediaModel.b());
            File l = d.a.m0.a.v2.u.l(this.f47750h, file.getName());
            if (l == null) {
                return;
            }
            mediaModel.h(l.getAbsolutePath());
            d.a.m0.a.v2.u.n(file, l, i2);
            mediaModel.g(l.length());
        }

        public final void c(VideoModel videoModel) {
            if (videoModel == null) {
                return;
            }
            if (d.a.m0.a.i1.d.c.c.f46647a) {
                Log.d("CompressTask", "compressVideo : " + videoModel.b());
            }
            File l = d.a.m0.a.v2.u.l(this.f47750h, new File(videoModel.b()).getName());
            if (l == null) {
                return;
            }
            d.a.m0.t.d.f(new File(videoModel.b()), l);
            videoModel.h(l.getPath());
            videoModel.g(l.length());
        }

        public final void d(MediaModel mediaModel) {
            if (mediaModel == null) {
                return;
            }
            File file = new File(mediaModel.b());
            File l = d.a.m0.a.v2.u.l(this.f47750h, file.getName());
            if (l == null || !l.exists() || d.a.m0.t.d.f(file, l) == 0) {
                return;
            }
            mediaModel.h(l.getPath());
        }

        public final void e() {
            this.k = new a(this.j);
            d.a.m0.a.c1.a.b().registerActivityLifecycleCallbacks(this.k);
        }

        public final void f() {
            if (this.k != null) {
                d.a.m0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.k);
                this.k = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            e();
            HandlerC0845b handlerC0845b = this.j;
            if (handlerC0845b != null) {
                handlerC0845b.sendEmptyMessage(1);
            }
            if (this.f47749g) {
                Iterator<MediaModel> it = this.f47748f.iterator();
                while (it.hasNext()) {
                    MediaModel next = it.next();
                    if (next != null) {
                        if (next instanceof ImageModel) {
                            if (TextUtils.equals(d.a.m0.t.d.s(next.b()), "gif")) {
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
                Iterator<MediaModel> it2 = this.f47748f.iterator();
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
            HandlerC0845b handlerC0845b2 = this.j;
            if (handlerC0845b2 != null) {
                handlerC0845b2.sendEmptyMessage(2);
            }
            d.a.m0.a.i1.d.d.d dVar = this.f47751i;
            if (dVar != null) {
                dVar.a(true, null, this.f47748f);
            }
            f();
        }
    }

    @Override // d.a.m0.a.p.d.x
    public void a(Activity activity, Bundle bundle, d.a.m0.a.i1.d.d.d dVar) {
        d.a.m0.a.v2.q.j(new b(activity, bundle, dVar), "main process compress files");
    }
}
