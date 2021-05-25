package d.a.l0.a.p.c;

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
public class m implements d.a.l0.a.p.d.x {

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Context f43965e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<MediaModel> f43966f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f43967g;

        /* renamed from: h  reason: collision with root package name */
        public String f43968h;

        /* renamed from: i  reason: collision with root package name */
        public d.a.l0.a.i1.d.d.d f43969i;
        public HandlerC0786b j;
        public a k;

        /* loaded from: classes2.dex */
        public class a extends d.a.l0.a.g1.a {

            /* renamed from: e  reason: collision with root package name */
            public HandlerC0786b f43970e;

            public a(HandlerC0786b handlerC0786b) {
                this.f43970e = handlerC0786b;
            }

            @Override // d.a.l0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                    if (this.f43970e.f43973b != null && this.f43970e.f43973b.isShowing()) {
                        this.f43970e.f43973b.cancel();
                        this.f43970e.f43973b = null;
                    }
                    HandlerC0786b handlerC0786b = this.f43970e;
                    if (handlerC0786b != null) {
                        handlerC0786b.removeMessages(1);
                        this.f43970e.removeMessages(2);
                        this.f43970e = null;
                    }
                    b.this.f();
                }
            }
        }

        /* renamed from: d.a.l0.a.p.c.m$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class HandlerC0786b extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<Context> f43972a;

            /* renamed from: b  reason: collision with root package name */
            public Dialog f43973b;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Dialog dialog;
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 == 2 && (dialog = this.f43973b) != null && dialog.isShowing()) {
                        Context context = this.f43972a.get();
                        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                            this.f43973b.cancel();
                        }
                        this.f43973b = null;
                        return;
                    }
                    return;
                }
                Context context2 = this.f43972a.get();
                if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                    return;
                }
                Dialog dialog2 = new Dialog(this.f43972a.get(), d.a.l0.a.i.SwanAppCompressDialog);
                this.f43973b = dialog2;
                dialog2.setContentView(d.a.l0.a.g.swanapp_progress_dialog);
                this.f43973b.findViewById(d.a.l0.a.f.layer_night).setVisibility(d.a.l0.a.c1.a.H().a() ? 0 : 8);
                this.f43973b.setCancelable(false);
                this.f43973b.show();
            }

            public HandlerC0786b(Context context) {
                this.f43972a = new WeakReference<>(context);
            }
        }

        public b(Context context, Bundle bundle, d.a.l0.a.i1.d.d.d dVar) {
            this.f43965e = context;
            this.f43966f = bundle.getParcelableArrayList("mediaModels");
            d.a.l0.a.v2.v.g(bundle, "swanAppId");
            this.f43967g = d.a.l0.a.v2.v.c(bundle, "compressed", false);
            this.f43968h = d.a.l0.a.v2.v.g(bundle, "swanTmpPath");
            this.f43969i = dVar;
            this.j = new HandlerC0786b(context);
        }

        public final void b(MediaModel mediaModel, int i2) {
            if (mediaModel == null) {
                return;
            }
            if (d.a.l0.a.i1.d.c.c.f42863a) {
                Log.d("CompressTask", "compressImg : " + mediaModel.b());
            }
            File file = new File(mediaModel.b());
            File l = d.a.l0.a.v2.u.l(this.f43968h, file.getName());
            if (l == null) {
                return;
            }
            mediaModel.h(l.getAbsolutePath());
            d.a.l0.a.v2.u.n(file, l, i2);
            mediaModel.g(l.length());
        }

        public final void c(VideoModel videoModel) {
            if (videoModel == null) {
                return;
            }
            if (d.a.l0.a.i1.d.c.c.f42863a) {
                Log.d("CompressTask", "compressVideo : " + videoModel.b());
            }
            File l = d.a.l0.a.v2.u.l(this.f43968h, new File(videoModel.b()).getName());
            if (l == null) {
                return;
            }
            d.a.l0.t.d.f(new File(videoModel.b()), l);
            videoModel.h(l.getPath());
            videoModel.g(l.length());
        }

        public final void d(MediaModel mediaModel) {
            if (mediaModel == null) {
                return;
            }
            File file = new File(mediaModel.b());
            File l = d.a.l0.a.v2.u.l(this.f43968h, file.getName());
            if (l == null || !l.exists() || d.a.l0.t.d.f(file, l) == 0) {
                return;
            }
            mediaModel.h(l.getPath());
        }

        public final void e() {
            this.k = new a(this.j);
            d.a.l0.a.c1.a.b().registerActivityLifecycleCallbacks(this.k);
        }

        public final void f() {
            if (this.k != null) {
                d.a.l0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.k);
                this.k = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            e();
            HandlerC0786b handlerC0786b = this.j;
            if (handlerC0786b != null) {
                handlerC0786b.sendEmptyMessage(1);
            }
            if (this.f43967g) {
                Iterator<MediaModel> it = this.f43966f.iterator();
                while (it.hasNext()) {
                    MediaModel next = it.next();
                    if (next != null) {
                        if (next instanceof ImageModel) {
                            if (TextUtils.equals(d.a.l0.t.d.s(next.b()), "gif")) {
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
                Iterator<MediaModel> it2 = this.f43966f.iterator();
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
            HandlerC0786b handlerC0786b2 = this.j;
            if (handlerC0786b2 != null) {
                handlerC0786b2.sendEmptyMessage(2);
            }
            d.a.l0.a.i1.d.d.d dVar = this.f43969i;
            if (dVar != null) {
                dVar.a(true, null, this.f43966f);
            }
            f();
        }
    }

    @Override // d.a.l0.a.p.d.x
    public void a(Activity activity, Bundle bundle, d.a.l0.a.i1.d.d.d dVar) {
        d.a.l0.a.v2.q.j(new b(activity, bundle, dVar), "main process compress files");
    }
}
