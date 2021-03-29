package d.b.i0.s.b.r;

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
import com.baidu.tieba.R;
import d.b.g0.a.i2.t;
import d.b.g0.a.i2.u;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Context f60122e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f60123f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60124g;

    /* renamed from: h  reason: collision with root package name */
    public String f60125h;
    public d.b.g0.a.b1.d.d.d i;
    public c j;
    public C1533b k;

    /* renamed from: d.b.i0.s.b.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1533b extends d.b.g0.a.z0.a {

        /* renamed from: e  reason: collision with root package name */
        public c f60126e;

        public C1533b(c cVar) {
            this.f60126e = cVar;
        }

        @Override // d.b.g0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                if (this.f60126e.f60129b != null && this.f60126e.f60129b.isShowing()) {
                    this.f60126e.f60129b.cancel();
                    this.f60126e.f60129b = null;
                }
                c cVar = this.f60126e;
                if (cVar != null) {
                    cVar.removeMessages(1);
                    this.f60126e.removeMessages(2);
                    this.f60126e = null;
                }
                b.this.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Context> f60128a;

        /* renamed from: b  reason: collision with root package name */
        public Dialog f60129b;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Dialog dialog;
            int i = message.what;
            if (i != 1) {
                if (i == 2 && (dialog = this.f60129b) != null && dialog.isShowing()) {
                    Context context = this.f60128a.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.f60129b.cancel();
                    }
                    this.f60129b = null;
                    return;
                }
                return;
            }
            Context context2 = this.f60128a.get();
            if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                return;
            }
            Dialog dialog2 = new Dialog(this.f60128a.get(), R.style.SwanAppCompressDialog);
            this.f60129b = dialog2;
            dialog2.setContentView(R.layout.swanapp_progress_dialog);
            this.f60129b.findViewById(R.id.layer_night).setVisibility(d.b.g0.a.w0.a.z().a() ? 0 : 8);
            this.f60129b.setCancelable(false);
            this.f60129b.show();
        }

        public c(Context context) {
            this.f60128a = new WeakReference<>(context);
        }
    }

    public b(Context context, Bundle bundle, d.b.g0.a.b1.d.d.d dVar) {
        this.f60122e = context;
        this.f60123f = bundle.getParcelableArrayList("mediaModels");
        u.g(bundle, "swanAppId");
        this.f60124g = u.c(bundle, "compressed", false);
        this.f60125h = u.g(bundle, "swanTmpPath");
        this.i = dVar;
        this.j = new c(context);
    }

    public final void b(MediaModel mediaModel, int i) {
        if (mediaModel == null) {
            return;
        }
        if (d.b.g0.a.b1.d.c.c.f43426a) {
            Log.d("CompressTask", "compressImg : " + mediaModel.b());
        }
        File file = new File(mediaModel.b());
        File d2 = t.d(this.f60125h, file.getName());
        if (d2 == null) {
            return;
        }
        mediaModel.h(d2.getAbsolutePath());
        t.a(file, d2, i);
        mediaModel.g(d2.length());
    }

    public final void c(VideoModel videoModel) {
        if (videoModel == null) {
            return;
        }
        if (d.b.g0.a.b1.d.c.c.f43426a) {
            Log.d("CompressTask", "compressVideo : " + videoModel.b());
        }
        File d2 = t.d(this.f60125h, new File(videoModel.b()).getName());
        if (d2 == null) {
            return;
        }
        d.b.g0.p.d.c(new File(videoModel.b()), d2);
        videoModel.h(d2.getPath());
        videoModel.g(d2.length());
    }

    public final void d(MediaModel mediaModel) {
        if (mediaModel == null) {
            return;
        }
        File file = new File(mediaModel.b());
        File d2 = t.d(this.f60125h, file.getName());
        if (d2 == null || !d2.exists() || d.b.g0.p.d.c(file, d2) == 0) {
            return;
        }
        mediaModel.h(d2.getPath());
    }

    public final void e() {
        this.k = new C1533b(this.j);
        d.b.g0.a.w0.a.c().registerActivityLifecycleCallbacks(this.k);
    }

    public final void f() {
        if (this.k != null) {
            d.b.g0.a.w0.a.c().unregisterActivityLifecycleCallbacks(this.k);
            this.k = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        e();
        c cVar = this.j;
        if (cVar != null) {
            cVar.sendEmptyMessage(1);
        }
        if (this.f60124g) {
            Iterator<MediaModel> it = this.f60123f.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(d.b.g0.p.d.l(next.b()), "gif")) {
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
            Iterator<MediaModel> it2 = this.f60123f.iterator();
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
        c cVar2 = this.j;
        if (cVar2 != null) {
            cVar2.sendEmptyMessage(2);
        }
        d.b.g0.a.b1.d.d.d dVar = this.i;
        if (dVar != null) {
            dVar.a(true, null, this.f60123f);
        }
        f();
    }
}
