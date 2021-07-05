package d.a.y0.t;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RenderScript f71452a;

    /* renamed from: b  reason: collision with root package name */
    public ScriptIntrinsicYuvToRGB f71453b;

    /* renamed from: c  reason: collision with root package name */
    public Type.Builder f71454c;

    /* renamed from: d  reason: collision with root package name */
    public Type.Builder f71455d;

    /* renamed from: e  reason: collision with root package name */
    public Allocation f71456e;

    /* renamed from: f  reason: collision with root package name */
    public Allocation f71457f;

    public p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RenderScript create = RenderScript.create(context);
        this.f71452a = create;
        this.f71453b = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
    }

    public Bitmap a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            if (this.f71454c == null) {
                RenderScript renderScript = this.f71452a;
                Type.Builder x = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
                this.f71454c = x;
                this.f71456e = Allocation.createTyped(this.f71452a, x.create(), 1);
                RenderScript renderScript2 = this.f71452a;
                Type.Builder y = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i2).setY(i3);
                this.f71455d = y;
                this.f71457f = Allocation.createTyped(this.f71452a, y.create(), 1);
            }
            this.f71456e.copyFrom(bArr);
            this.f71453b.setInput(this.f71456e);
            this.f71453b.forEach(this.f71457f);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.f71457f.copyTo(createBitmap);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }
}
