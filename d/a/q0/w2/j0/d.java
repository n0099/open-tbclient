package d.a.q0.w2.j0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.w2.f0.b.f;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f66719a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f66720b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f66721c;

    public d(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66719a = 0;
        this.f66720b = context;
        this.f66721c = viewGroup;
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if ("apk_download".equals(str)) {
                return "apk_download".equals(str2);
            }
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str)) {
                return TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public e b(f fVar, e eVar) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, eVar)) == null) {
            if (fVar == null || (str = fVar.f66597a) == null) {
                return eVar;
            }
            if (eVar == null || !a(str, eVar.f66722a)) {
                ViewGroup viewGroup = this.f66721c;
                if (viewGroup == null) {
                    return null;
                }
                viewGroup.removeAllViews();
                if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(fVar.f66597a)) {
                    if (this.f66719a == 1) {
                        return new c(LayoutInflater.from(this.f66720b).inflate(R.layout.videolist_tail_frame_ad_jump, this.f66721c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    }
                    return new b(LayoutInflater.from(this.f66720b).inflate(R.layout.tail_frame_ad_jump, this.f66721c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                } else if ("apk_download".equals(fVar.f66597a)) {
                    return new a(LayoutInflater.from(this.f66720b).inflate(R.layout.tail_frame_ad_download, this.f66721c, true), "apk_download");
                } else {
                    return null;
                }
            }
            return eVar;
        }
        return (e) invokeLL.objValue;
    }
}
