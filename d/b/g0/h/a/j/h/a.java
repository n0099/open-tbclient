package d.b.g0.h.a.j.h;

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
import d.b.g0.a.e0.l.f;
import d.b.g0.a.i2.a0;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.z0.f;
import d.b.g0.p.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.e0.l.c implements IWNaviStatusListener, IWTTSPlayer {
    public static final boolean C0 = k.f45443a;
    public BaseNpcModel A0;
    public boolean B0;
    public WalkNavigateHelper y0;
    public FrameLayout z0;

    /* renamed from: d.b.g0.h.a.j.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1026a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f49216a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f49217b;

        /* renamed from: d.b.g0.h.a.j.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1027a implements IWMoreNPCModelOnClickListener {
            public C1027a() {
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

        public C1026a(Bundle bundle, Context context) {
            this.f49216a = bundle;
            this.f49217b = context;
        }

        @Override // d.b.g0.h.a.j.h.a.c
        public void a(Bitmap bitmap) {
            Bundle bundle = this.f49216a;
            String string = bundle != null ? bundle.getString("guideKey") : "";
            if (!TextUtils.isEmpty(string)) {
                BaseNpcModel baseNpcModel = new BaseNpcModel();
                baseNpcModel.setDownLoadKey(string);
                if (bitmap != null) {
                    bitmap = a.this.H2(bitmap, h0.e(this.f49217b, 44.0f), h0.e(this.f49217b, 44.0f));
                }
                Bitmap decodeResource = BitmapFactory.decodeResource(a.this.u(), R.drawable.aiapps_wsdk_npc_drawer_default);
                if (bitmap == null) {
                    bitmap = decodeResource;
                }
                baseNpcModel.setIcon(bitmap);
                ArrayList<BaseNpcModel> arrayList = new ArrayList<>();
                arrayList.add(baseNpcModel);
                a.this.A0 = baseNpcModel;
                a.this.y0.addMoreNPCModelOnClickListener(new C1027a());
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
        public final /* synthetic */ c f49220a;

        public b(c cVar) {
            this.f49220a = cVar;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (a.C0) {
                Log.e("WalkARNavFragment", "onFailureImpl");
            }
            this.f49220a.a(null);
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (a.C0) {
                Log.e("WalkARNavFragment", "onNewResultImpl");
            }
            this.f49220a.a(bitmap.copy(bitmap.getConfig() == null ? Bitmap.Config.ARGB_8888 : bitmap.getConfig(), true));
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    public static a I2(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.d1(bundle);
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
    public final void F2(Context context, String str, c cVar) {
        FileInputStream fileInputStream;
        Closeable closeable = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            if (d.b.g0.a.a2.b.c(str) == PathType.NETWORK) {
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
    public final void G2() {
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

    public final Bitmap H2(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode);
        Paint paint = new Paint(1);
        paint.setShader(bitmapShader);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap.getWidth(), createBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap2).drawOval(new RectF(new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight())), paint);
        return createBitmap2;
    }

    public void J2() {
        d.b.g0.a.e0.l.f W = f.V().W();
        if (W != null) {
            f.b i = W.i("navigateTo");
            i.n(d.b.g0.a.e0.l.f.f44405g, d.b.g0.a.e0.l.f.i);
            i.j(this);
            i.b();
        }
    }

    public final void K2() {
        SDKInitializer.setCoordType(CoordType.BD09LL);
        try {
            WalkNavigateHelper walkNavigateHelper = WalkNavigateHelper.getInstance();
            this.y0 = walkNavigateHelper;
            View onCreate = walkNavigateHelper.onCreate(d.b.g0.a.z0.f.V().getActivity());
            if (onCreate != null) {
                this.z0.addView(onCreate);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        WalkNaviDisplayOption walkNaviDisplayOption = new WalkNaviDisplayOption();
        walkNaviDisplayOption.runInFragment(true);
        this.y0.setWalkNaviDisplayOption(walkNaviDisplayOption);
        Bundle j = j();
        String string = j != null ? j.getString("guideIcon") : "";
        if (C0) {
            Log.e("WalkARNavFragment", "guideIconPath = " + string);
        }
        Context l = l();
        F2(l, string, new C1026a(j, l));
    }

    @Override // d.b.g0.a.e0.l.c
    public void M1(View view) {
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean T1() {
        return false;
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean V1() {
        return false;
    }

    @Override // d.b.g0.a.e0.l.c
    public void a2() {
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.y0 != null) {
            G2();
            this.y0.quit();
        }
        SDKInitializer.setCoordType(CoordType.GCJ02);
        h1();
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().clearFlags(128);
        }
        d.b.g0.a.z0.f.V().f();
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
        d.b.g0.a.z0.f.V().D();
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        WalkNavigateHelper walkNavigateHelper = this.y0;
        if (walkNavigateHelper != null) {
            walkNavigateHelper.resume();
        }
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
    public void onWalkNaviModeChange(int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        this.y0.switchWalkNaviMode(d.b.g0.a.z0.f.V().getActivity(), i, walkNaviModeSwitchListener);
        if (i != 2 || this.B0 || this.y0 == null || this.A0 == null || a0.b("switch_npc_mode", false)) {
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

    @Override // d.b.g0.a.e0.l.c
    public boolean v() {
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            return null;
        }
        d.b.g0.h.a.a.a();
        View inflate = layoutInflater.inflate(R.layout.walk_arnav_fragment, viewGroup, false);
        this.z0 = (FrameLayout) inflate;
        K2();
        if (L1()) {
            inflate = O1(inflate);
        }
        return v1(inflate, this);
    }
}
