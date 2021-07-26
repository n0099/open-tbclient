package d.j.a.f;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.opensource.svgaplayer.SVGAVideoEntity;
import d.j.a.g.f;
import d.j.a.g.g;
import d.j.a.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f71459a;

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f71460b;

    /* renamed from: d.j.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C2007a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f71461a;

        /* renamed from: b  reason: collision with root package name */
        public final g f71462b;

        public C2007a(a aVar, String str, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71461a = str;
            this.f71462b = gVar;
        }

        public final g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71462b : (g) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71461a : (String) invokeV.objValue;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVGAVideoEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71460b = sVGAVideoEntity;
        this.f71459a = new e();
    }

    public void a(Canvas canvas, int i2, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, canvas, i2, scaleType) == null) {
            this.f71459a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f71460b.h().b(), (float) this.f71460b.h().a(), scaleType);
        }
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71459a : (e) invokeV.objValue;
    }

    public final SVGAVideoEntity c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f71460b : (SVGAVideoEntity) invokeV.objValue;
    }

    public final List<C2007a> d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            List<f> g2 = this.f71460b.g();
            ArrayList arrayList = new ArrayList();
            for (f fVar : g2) {
                C2007a c2007a = null;
                if (i2 >= 0 && i2 < fVar.a().size() && fVar.a().get(i2).a() > 0.0d) {
                    c2007a = new C2007a(this, fVar.b(), fVar.a().get(i2));
                }
                if (c2007a != null) {
                    arrayList.add(c2007a);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
