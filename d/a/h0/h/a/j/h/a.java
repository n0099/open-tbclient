package d.a.h0.h.a.j.h;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.R;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.i2.a0;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.z0.f;
import d.a.h0.p.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends d.a.h0.a.e0.l.c implements IWNaviStatusListener, IWTTSPlayer {
    public static final boolean C0 = k.f43101a;
    public BaseNpcModel A0;
    public boolean B0;
    public WalkNavigateHelper y0;
    public FrameLayout z0;

    /* renamed from: d.a.h0.h.a.j.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0985a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f47048a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f47049b;

        /* renamed from: d.a.h0.h.a.j.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0986a implements IWMoreNPCModelOnClickListener {
            public C0986a() {
            }

            @Override // com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener
            public void onMoreNPCModelOnClick(View view) {
                if (a.C0) {
                    Log.e("WalkARNavFragment", "npc model onMoreNPCModelOnClick");
                }
                ArrayList<BaseNpcModel> walkNpcModelInfoList = a.this.y0.getWalkNpcModelInfoList();
                if (walkNpcModelInfoList == null || walkNpcModelInfoList.size() <= 0) {
                    return;
                }
                if (a.C0) {
                    Log.e("WalkARNavFragment", "models size :" + walkNpcModelInfoList.size());
                }
                a.this.y0.switchNPCModel(walkNpcModelInfoList.get(walkNpcModelInfoList.size() - 1));
            }
        }

        public C0985a(Bundle bundle, Context context) {
            this.f47048a = bundle;
            this.f47049b = context;
        }

        @Override // d.a.h0.h.a.j.h.a.c
        public void a(Bitmap bitmap) {
            Bundle bundle = this.f47048a;
            String string = bundle != null ? bundle.getString("guideKey") : "";
            if (!TextUtils.isEmpty(string)) {
                BaseNpcModel baseNpcModel = new BaseNpcModel();
                baseNpcModel.setDownLoadKey(string);
                if (bitmap != null) {
                    bitmap = a.this.G2(bitmap, h0.e(this.f47049b, 44.0f), h0.e(this.f47049b, 44.0f));
                }
                Bitmap decodeResource = BitmapFactory.decodeResource(a.this.t(), R.drawable.aiapps_wsdk_npc_drawer_default);
                if (bitmap == null) {
                    bitmap = decodeResource;
                }
                baseNpcModel.setIcon(bitmap);
                ArrayList<BaseNpcModel> arrayList = new ArrayList<>();
                arrayList.add(baseNpcModel);
                a.this.A0 = baseNpcModel;
                a.this.y0.addMoreNPCModelOnClickListener(new C0986a());
                a.this.y0.setWalkNpcModelInfoList(arrayList);
            }
            a.this.y0.setWalkNaviStatusListener(a.this);
            a.this.y0.setTTsPlayer(a.this);
            a.this.y0.startWalkNavi(f.V().getActivity());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f47052a;

        public b(c cVar) {
            this.f47052a = cVar;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (a.C0) {
                Log.e("WalkARNavFragment", "onFailureImpl");
            }
            this.f47052a.a(null);
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (a.C0) {
                Log.e("WalkARNavFragment", "onNewResultImpl");
            }
            this.f47052a.a(bitmap.copy(bitmap.getConfig() == null ? Bitmap.Config.ARGB_8888 : bitmap.getConfig(), true));
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    public static a H2(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.c1(bundle);
        }
        return aVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x005a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0047 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.Closeable] */
    public final void E2(Context context, String str, c cVar) {
        FileInputStream fileInputStream;
        Closeable closeable = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            if (d.a.h0.a.a2.b.c(str) == PathType.NETWORK) {
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(k0.y(str)).build(), AppRuntime.getAppContext()).subscribe(new b(cVar), UiThreadImmediateExecutorService.getInstance());
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                ?? isFile = file.isFile();
                try {
                    if (isFile != 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                cVar.a(BitmapFactory.decodeStream(fileInputStream));
                                isFile = fileInputStream;
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                cVar.a(null);
                                isFile = fileInputStream;
                                if (C0) {
                                    e.printStackTrace();
                                    isFile = fileInputStream;
                                }
                                d.a(isFile);
                                return;
                            }
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            d.a(closeable);
                            throw th;
                        }
                        d.a(isFile);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeable = isFile;
                }
            }
            cVar.a(null);
            return;
        }
        cVar.a(null);
    }

    @TargetApi(19)
    public final void F2() {
        if (Build.VERSION.SDK_INT > 19) {
            return;
        }
        try {
            Field declaredField = WalkNavigateHelper.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(WalkNavigateHelper.getInstance());
            Field declaredField2 = obj.getClass().getDeclaredField("c");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, null);
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public final Bitmap G2(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode);
        Paint paint = new Paint(1);
        paint.setShader(bitmapShader);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap.getWidth(), createBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap2).drawOval(new RectF(new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight())), paint);
        return createBitmap2;
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean I() {
        return false;
    }

    public void I2() {
        d.a.h0.a.e0.l.f W = f.V().W();
        if (W != null) {
            f.b i2 = W.i("navigateTo");
            i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
            i2.j(this);
            i2.b();
        }
    }

    public final void J2() {
        SDKInitializer.setCoordType(CoordType.BD09LL);
        try {
            WalkNavigateHelper walkNavigateHelper = WalkNavigateHelper.getInstance();
            this.y0 = walkNavigateHelper;
            View onCreate = walkNavigateHelper.onCreate(d.a.h0.a.z0.f.V().getActivity());
            if (onCreate != null) {
                this.z0.addView(onCreate);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        WalkNaviDisplayOption walkNaviDisplayOption = new WalkNaviDisplayOption();
        walkNaviDisplayOption.runInFragment(true);
        this.y0.setWalkNaviDisplayOption(walkNaviDisplayOption);
        Bundle i2 = i();
        String string = i2 != null ? i2.getString("guideIcon") : "";
        if (C0) {
            Log.e("WalkARNavFragment", "guideIconPath = " + string);
        }
        Context m = m();
        E2(m, string, new C0985a(i2, m));
    }

    @Override // d.a.h0.a.e0.l.c
    public void L1(View view) {
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean S1() {
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean U1() {
        return false;
    }

    @Override // d.a.h0.a.e0.l.c
    public void Z1() {
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.y0 != null) {
            F2();
            this.y0.quit();
        }
        SDKInitializer.setCoordType(CoordType.GCJ02);
        g1();
        SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().clearFlags(128);
        }
        d.a.h0.a.z0.f.V().d();
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
    public void onNaviExit() {
        if (C0) {
            Log.e("WalkARNavFragment", "nav exit,exit fragment");
        }
        if (f() != null) {
            f().onBackPressed();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        WalkNavigateHelper walkNavigateHelper = this.y0;
        if (walkNavigateHelper != null) {
            walkNavigateHelper.pause();
        }
        d.a.h0.a.z0.f.V().r();
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        WalkNavigateHelper walkNavigateHelper = this.y0;
        if (walkNavigateHelper != null) {
            walkNavigateHelper.resume();
        }
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
    public void onWalkNaviModeChange(int i2, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        this.y0.switchWalkNaviMode(d.a.h0.a.z0.f.V().getActivity(), i2, walkNaviModeSwitchListener);
        if (i2 != 2 || this.B0 || this.y0 == null || this.A0 == null || a0.b("switch_npc_mode", false)) {
            return;
        }
        this.y0.switchNPCModel(this.A0);
        this.B0 = true;
        a0.d("switch_npc_mode", true);
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWTTSPlayer
    public int playTTSText(String str, boolean z) {
        return 0;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            return null;
        }
        d.a.h0.h.a.a.a();
        View inflate = layoutInflater.inflate(R.layout.walk_arnav_fragment, viewGroup, false);
        this.z0 = (FrameLayout) inflate;
        J2();
        if (K1()) {
            inflate = N1(inflate);
        }
        return u1(inflate, this);
    }
}
