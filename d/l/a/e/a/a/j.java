package d.l.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class j extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, d.l.a.e.b.j.a aVar, String str) {
        super(context, aVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (d.l.a.e.b.j.a) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.l.a.e.a.a.e
    public Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Intent intent = new Intent("com.android.filemanager.FILE_OPEN");
            intent.putExtra("FilePathToBeOpenAfterScan", this.f74518c);
            intent.putExtra("com.iqoo.secure", true);
            intent.putExtra("OpenParentAndLocationDestFile", true);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.addFlags(32768);
            intent.addFlags(1073741824);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }
}
