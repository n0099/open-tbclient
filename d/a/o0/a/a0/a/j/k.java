package d.a.o0.a.a0.a.j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class k extends d.a.o0.a.a0.a.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f43762a;

    /* renamed from: b  reason: collision with root package name */
    public int f43763b;

    /* renamed from: c  reason: collision with root package name */
    public int f43764c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f43765d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f43766e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f43767f;

    /* renamed from: g  reason: collision with root package name */
    public int f43768g;

    /* renamed from: h  reason: collision with root package name */
    public Uri f43769h;

    /* renamed from: i  reason: collision with root package name */
    public String f43770i;

    /* loaded from: classes7.dex */
    public class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f43771a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f43772b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f43773c;

        public a(k kVar, DataSource dataSource, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, dataSource, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43773c = kVar;
            this.f43771a = dataSource;
            this.f43772b = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                if (dataSource != null) {
                    dataSource.close();
                }
                this.f43773c.f43768g = 3;
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (this.f43771a.isFinished() && bitmap != null) {
                    this.f43773c.f43767f = Bitmap.createBitmap(bitmap);
                    this.f43771a.close();
                    CanvasView canvasView = this.f43772b.l;
                    if (canvasView != null) {
                        canvasView.postInvalidate();
                    }
                }
                this.f43773c.f43768g = 2;
            }
        }
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43768g = 0;
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (h(bVar)) {
                int alpha = bVar.f43725h.getAlpha();
                bVar.f(bVar.f43725h);
                Rect rect = this.f43766e;
                if (rect != null) {
                    canvas.drawBitmap(this.f43767f, this.f43765d, rect, bVar.f43725h);
                } else {
                    canvas.drawBitmap(this.f43767f, this.f43763b, this.f43764c, bVar.f43725h);
                }
                bVar.f43725h.setAlpha(alpha);
                return;
            }
            try {
                j(bVar);
            } catch (Exception e2) {
                if (d.a.o0.a.k.f46335a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            try {
                int length = jSONArray.length();
                if (length > 0) {
                    this.f43770i = this.f43762a;
                    String optString = jSONArray.optString(0);
                    this.f43762a = optString;
                    this.f43762a = f(Q, optString);
                }
                if (length > 2) {
                    this.f43763b = i(jSONArray, 1);
                    this.f43764c = i(jSONArray, 2);
                }
                if (length > 4) {
                    int i2 = this.f43763b;
                    int i3 = this.f43764c;
                    int i4 = i(jSONArray, 3);
                    int i5 = i(jSONArray, 4);
                    if (i4 > 0 && i5 > 0) {
                        this.f43766e = new Rect(i2, i3, i4 + i2, i5 + i3);
                    }
                }
                if (length > 8) {
                    int optInt = jSONArray.optInt(5);
                    int optInt2 = jSONArray.optInt(6);
                    int optInt3 = jSONArray.optInt(7);
                    int optInt4 = jSONArray.optInt(8);
                    if (optInt3 > 0 && optInt4 > 0) {
                        this.f43765d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                    }
                }
                if (Q != null) {
                    String g2 = g(this.f43762a, Q);
                    if (!TextUtils.isEmpty(g2)) {
                        this.f43767f = BitmapFactory.decodeFile(g2);
                    } else if (TextUtils.isEmpty(this.f43762a)) {
                    } else {
                        if (this.f43769h == null || !TextUtils.equals(this.f43762a, this.f43770i)) {
                            this.f43769h = Uri.parse(this.f43762a);
                        }
                    }
                }
            } catch (Exception e2) {
                if (d.a.o0.a.k.f46335a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) || hashMap == null || TextUtils.isEmpty(this.f43762a) || this.f43767f == null || hashMap.containsKey(this.f43762a)) {
            return;
        }
        hashMap.put(this.f43762a, this.f43767f);
    }

    public final String f(d.a.o0.a.a2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, str)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    return ("bdfile".equalsIgnoreCase(URI.create(str).getScheme()) || str.startsWith(d.a.o0.a.v2.q0.x(eVar).getPath())) ? str : d.a.o0.a.v2.q0.w(eVar, str);
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final String g(String str, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, eVar)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        str = d.a.o0.a.k2.b.M(str, eVar.f43885f);
                    }
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        return file.getAbsolutePath();
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean h(b bVar) {
        InterceptResult invokeL;
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            if (this.f43767f != null) {
                return true;
            }
            if (this.f43769h == null || bVar == null || (canvasView = bVar.l) == null) {
                return false;
            }
            Bitmap e2 = canvasView.e(this.f43762a);
            this.f43767f = e2;
            if (e2 != null) {
                return true;
            }
            Bitmap c2 = d.a.o0.a.v2.t.c(this.f43769h, bVar.l.getContext());
            this.f43767f = c2;
            return c2 != null;
        }
        return invokeL.booleanValue;
    }

    public final int i(JSONArray jSONArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, jSONArray, i2)) == null) ? d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(i2)) : invokeLI.intValue;
    }

    @UiThread
    public final void j(b bVar) {
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || this.f43768g != 0 || (canvasView = bVar.l) == null || canvasView.getContext() == null || TextUtils.isEmpty(this.f43762a)) {
            return;
        }
        this.f43768g = 1;
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.f43762a)).build(), bVar.l.getContext());
        fetchDecodedImage.subscribe(new a(this, fetchDecodedImage, bVar), UiThreadImmediateExecutorService.getInstance());
    }
}
