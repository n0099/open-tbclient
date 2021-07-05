package d.a.q0.a.a0.a.j;

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
/* loaded from: classes8.dex */
public class k extends d.a.q0.a.a0.a.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f46560a;

    /* renamed from: b  reason: collision with root package name */
    public int f46561b;

    /* renamed from: c  reason: collision with root package name */
    public int f46562c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f46563d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f46564e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f46565f;

    /* renamed from: g  reason: collision with root package name */
    public int f46566g;

    /* renamed from: h  reason: collision with root package name */
    public Uri f46567h;

    /* renamed from: i  reason: collision with root package name */
    public String f46568i;

    /* loaded from: classes8.dex */
    public class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f46569a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f46570b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f46571c;

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
            this.f46571c = kVar;
            this.f46569a = dataSource;
            this.f46570b = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                if (dataSource != null) {
                    dataSource.close();
                }
                this.f46571c.f46566g = 3;
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (this.f46569a.isFinished() && bitmap != null) {
                    this.f46571c.f46565f = Bitmap.createBitmap(bitmap);
                    this.f46569a.close();
                    CanvasView canvasView = this.f46570b.l;
                    if (canvasView != null) {
                        canvasView.postInvalidate();
                    }
                }
                this.f46571c.f46566g = 2;
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
        this.f46566g = 0;
    }

    @Override // d.a.q0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (h(bVar)) {
                int alpha = bVar.f46523h.getAlpha();
                bVar.f(bVar.f46523h);
                Rect rect = this.f46564e;
                if (rect != null) {
                    canvas.drawBitmap(this.f46565f, this.f46563d, rect, bVar.f46523h);
                } else {
                    canvas.drawBitmap(this.f46565f, this.f46561b, this.f46562c, bVar.f46523h);
                }
                bVar.f46523h.setAlpha(alpha);
                return;
            }
            try {
                j(bVar);
            } catch (Exception e2) {
                if (d.a.q0.a.k.f49133a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // d.a.q0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            try {
                int length = jSONArray.length();
                if (length > 0) {
                    this.f46568i = this.f46560a;
                    String optString = jSONArray.optString(0);
                    this.f46560a = optString;
                    this.f46560a = f(Q, optString);
                }
                if (length > 2) {
                    this.f46561b = i(jSONArray, 1);
                    this.f46562c = i(jSONArray, 2);
                }
                if (length > 4) {
                    int i2 = this.f46561b;
                    int i3 = this.f46562c;
                    int i4 = i(jSONArray, 3);
                    int i5 = i(jSONArray, 4);
                    if (i4 > 0 && i5 > 0) {
                        this.f46564e = new Rect(i2, i3, i4 + i2, i5 + i3);
                    }
                }
                if (length > 8) {
                    int optInt = jSONArray.optInt(5);
                    int optInt2 = jSONArray.optInt(6);
                    int optInt3 = jSONArray.optInt(7);
                    int optInt4 = jSONArray.optInt(8);
                    if (optInt3 > 0 && optInt4 > 0) {
                        this.f46563d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                    }
                }
                if (Q != null) {
                    String g2 = g(this.f46560a, Q);
                    if (!TextUtils.isEmpty(g2)) {
                        this.f46565f = BitmapFactory.decodeFile(g2);
                    } else if (TextUtils.isEmpty(this.f46560a)) {
                    } else {
                        if (this.f46567h == null || !TextUtils.equals(this.f46560a, this.f46568i)) {
                            this.f46567h = Uri.parse(this.f46560a);
                        }
                    }
                }
            } catch (Exception e2) {
                if (d.a.q0.a.k.f49133a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) || hashMap == null || TextUtils.isEmpty(this.f46560a) || this.f46565f == null || hashMap.containsKey(this.f46560a)) {
            return;
        }
        hashMap.put(this.f46560a, this.f46565f);
    }

    public final String f(d.a.q0.a.a2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, str)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    return ("bdfile".equalsIgnoreCase(URI.create(str).getScheme()) || str.startsWith(d.a.q0.a.v2.q0.x(eVar).getPath())) ? str : d.a.q0.a.v2.q0.w(eVar, str);
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final String g(String str, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, eVar)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        str = d.a.q0.a.k2.b.M(str, eVar.f46683f);
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
            if (this.f46565f != null) {
                return true;
            }
            if (this.f46567h == null || bVar == null || (canvasView = bVar.l) == null) {
                return false;
            }
            Bitmap e2 = canvasView.e(this.f46560a);
            this.f46565f = e2;
            if (e2 != null) {
                return true;
            }
            Bitmap c2 = d.a.q0.a.v2.t.c(this.f46567h, bVar.l.getContext());
            this.f46565f = c2;
            return c2 != null;
        }
        return invokeL.booleanValue;
    }

    public final int i(JSONArray jSONArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, jSONArray, i2)) == null) ? d.a.q0.a.v2.n0.g((float) jSONArray.optDouble(i2)) : invokeLI.intValue;
    }

    @UiThread
    public final void j(b bVar) {
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || this.f46566g != 0 || (canvasView = bVar.l) == null || canvasView.getContext() == null || TextUtils.isEmpty(this.f46560a)) {
            return;
        }
        this.f46566g = 1;
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.f46560a)).build(), bVar.l.getContext());
        fetchDecodedImage.subscribe(new a(this, fetchDecodedImage, bVar), UiThreadImmediateExecutorService.getInstance());
    }
}
