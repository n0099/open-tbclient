package d.a.s0.l0.i.c;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TiebaFieldsInfo;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f62904a;

    /* renamed from: b  reason: collision with root package name */
    public String f62905b;

    /* renamed from: c  reason: collision with root package name */
    public MetaData f62906c;

    /* renamed from: d  reason: collision with root package name */
    public long f62907d;

    /* renamed from: e  reason: collision with root package name */
    public String f62908e;

    /* renamed from: f  reason: collision with root package name */
    public TiebaFieldsInfo f62909f;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
