package d.a.v0.t;

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
/* loaded from: classes8.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RenderScript f68255a;

    /* renamed from: b  reason: collision with root package name */
    public ScriptIntrinsicYuvToRGB f68256b;

    /* renamed from: c  reason: collision with root package name */
    public Type.Builder f68257c;

    /* renamed from: d  reason: collision with root package name */
    public Type.Builder f68258d;

    /* renamed from: e  reason: collision with root package name */
    public Allocation f68259e;

    /* renamed from: f  reason: collision with root package name */
    public Allocation f68260f;

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
        this.f68255a = create;
        this.f68256b = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
    }

    public Bitmap a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            if (this.f68257c == null) {
                RenderScript renderScript = this.f68255a;
                Type.Builder x = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
                this.f68257c = x;
                this.f68259e = Allocation.createTyped(this.f68255a, x.create(), 1);
                RenderScript renderScript2 = this.f68255a;
                Type.Builder y = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i2).setY(i3);
                this.f68258d = y;
                this.f68260f = Allocation.createTyped(this.f68255a, y.create(), 1);
            }
            this.f68259e.copyFrom(bArr);
            this.f68256b.setInput(this.f68259e);
            this.f68256b.forEach(this.f68260f);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.f68260f.copyTo(createBitmap);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }
}
