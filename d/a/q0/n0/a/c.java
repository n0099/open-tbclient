package d.a.q0.n0.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n0.a.f.e;
import java.io.File;
/* loaded from: classes8.dex */
public class c implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.n0.a.e.a f61025a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61026b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61027c;

    /* renamed from: d  reason: collision with root package name */
    public b f61028d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61029e;

    public c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61027c = false;
        this.f61029e = false;
        this.f61025a = new d.a.q0.n0.a.e.a();
        this.f61029e = z;
    }

    @Override // d.a.q0.n0.a.f.e
    public void a(String str, d.a.q0.n0.a.g.b bVar) {
        b bVar2;
        b bVar3;
        float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) || bVar == null) {
            return;
        }
        if (this.f61026b) {
            File file = new File(bVar.f61055a);
            Bitmap decodeFile = BitmapFactory.decodeFile(bVar.f61055a);
            if (file.exists() && decodeFile != null) {
                float height = decodeFile.getHeight();
                float width = decodeFile.getWidth();
                float f3 = height * 1.0f;
                float f4 = f3 / width;
                float f5 = f4 > 1.0f ? 1.7777778f : 0.75f;
                float f6 = 0.0f;
                if (f4 > f5) {
                    float f7 = f5 * width;
                    f2 = (height - f7) * 0.5f;
                    height = f7;
                } else {
                    float f8 = f3 / f5;
                    f6 = (width - f8) * 0.5f;
                    width = f8;
                    f2 = 0.0f;
                }
                bVar.f61055a = FileHelper.saveFile(file.getPath(), file.getName(), Bitmap.createBitmap(decodeFile, (int) f6, (int) f2, (int) width, (int) height), 95);
            }
        }
        if ("default".equals(str)) {
            if (this.f61027c || (bVar3 = this.f61028d) == null) {
                return;
            }
            bVar3.onCoverPathCallBack(bVar.f61055a);
        } else if (!"manual".equals(str) || (bVar2 = this.f61028d) == null) {
        } else {
            bVar2.onCoverPathCallBack(bVar.f61055a);
        }
    }

    public void b(d.a.q0.n0.a.g.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str) == null) {
            this.f61025a.a(str, this.f61029e).a(cVar, this);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f61027c = z;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f61026b = z;
        }
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f61028d = bVar;
        }
    }

    @Override // d.a.q0.n0.a.f.e
    public void onError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            BdLog.e("get cover error ! type : " + str + ", err : " + str2);
        }
    }
}
