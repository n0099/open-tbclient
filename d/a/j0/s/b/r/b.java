package d.a.j0.s.b.r;

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
import d.a.h0.a.i2.t;
import d.a.h0.a.i2.u;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Context f60004e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f60005f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60006g;

    /* renamed from: h  reason: collision with root package name */
    public String f60007h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.h0.a.b1.d.d.d f60008i;
    public c j;
    public C1534b k;

    /* renamed from: d.a.j0.s.b.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1534b extends d.a.h0.a.z0.a {

        /* renamed from: e  reason: collision with root package name */
        public c f60009e;

        public C1534b(c cVar) {
            this.f60009e = cVar;
        }

        @Override // d.a.h0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                if (this.f60009e.f60012b != null && this.f60009e.f60012b.isShowing()) {
                    this.f60009e.f60012b.cancel();
                    this.f60009e.f60012b = null;
                }
                c cVar = this.f60009e;
                if (cVar != null) {
                    cVar.removeMessages(1);
                    this.f60009e.removeMessages(2);
                    this.f60009e = null;
                }
                b.this.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Context> f60011a;

        /* renamed from: b  reason: collision with root package name */
        public Dialog f60012b;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Dialog dialog;
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2 && (dialog = this.f60012b) != null && dialog.isShowing()) {
                    Context context = this.f60011a.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.f60012b.cancel();
                    }
                    this.f60012b = null;
                    return;
                }
                return;
            }
            Context context2 = this.f60011a.get();
            if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                return;
            }
            Dialog dialog2 = new Dialog(this.f60011a.get(), R.style.SwanAppCompressDialog);
            this.f60012b = dialog2;
            dialog2.setContentView(R.layout.swanapp_progress_dialog);
            this.f60012b.findViewById(R.id.layer_night).setVisibility(d.a.h0.a.w0.a.z().a() ? 0 : 8);
            this.f60012b.setCancelable(false);
            this.f60012b.show();
        }

        public c(Context context) {
            this.f60011a = new WeakReference<>(context);
        }
    }

    public b(Context context, Bundle bundle, d.a.h0.a.b1.d.d.d dVar) {
        this.f60004e = context;
        this.f60005f = bundle.getParcelableArrayList("mediaModels");
        u.g(bundle, "swanAppId");
        this.f60006g = u.c(bundle, "compressed", false);
        this.f60007h = u.g(bundle, "swanTmpPath");
        this.f60008i = dVar;
        this.j = new c(context);
    }

    public final void b(MediaModel mediaModel, int i2) {
        if (mediaModel == null) {
            return;
        }
        if (d.a.h0.a.b1.d.c.c.f41422a) {
            Log.d("CompressTask", "compressImg : " + mediaModel.b());
        }
        File file = new File(mediaModel.b());
        File d2 = t.d(this.f60007h, file.getName());
        if (d2 == null) {
            return;
        }
        mediaModel.h(d2.getAbsolutePath());
        t.a(file, d2, i2);
        mediaModel.g(d2.length());
    }

    public final void c(VideoModel videoModel) {
        if (videoModel == null) {
            return;
        }
        if (d.a.h0.a.b1.d.c.c.f41422a) {
            Log.d("CompressTask", "compressVideo : " + videoModel.b());
        }
        File d2 = t.d(this.f60007h, new File(videoModel.b()).getName());
        if (d2 == null) {
            return;
        }
        d.a.h0.p.d.c(new File(videoModel.b()), d2);
        videoModel.h(d2.getPath());
        videoModel.g(d2.length());
    }

    public final void d(MediaModel mediaModel) {
        if (mediaModel == null) {
            return;
        }
        File file = new File(mediaModel.b());
        File d2 = t.d(this.f60007h, file.getName());
        if (d2 == null || !d2.exists() || d.a.h0.p.d.c(file, d2) == 0) {
            return;
        }
        mediaModel.h(d2.getPath());
    }

    public final void e() {
        this.k = new C1534b(this.j);
        d.a.h0.a.w0.a.c().registerActivityLifecycleCallbacks(this.k);
    }

    public final void f() {
        if (this.k != null) {
            d.a.h0.a.w0.a.c().unregisterActivityLifecycleCallbacks(this.k);
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
        if (this.f60006g) {
            Iterator<MediaModel> it = this.f60005f.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(d.a.h0.p.d.l(next.b()), "gif")) {
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
            Iterator<MediaModel> it2 = this.f60005f.iterator();
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
        d.a.h0.a.b1.d.d.d dVar = this.f60008i;
        if (dVar != null) {
            dVar.a(true, null, this.f60005f);
        }
        f();
    }
}
