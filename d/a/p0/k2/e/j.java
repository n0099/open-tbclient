package d.a.p0.k2.e;

import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59414a;

    /* renamed from: b  reason: collision with root package name */
    public String f59415b;

    /* renamed from: c  reason: collision with root package name */
    public String f59416c;

    /* renamed from: d  reason: collision with root package name */
    public String f59417d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f59418e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f59419f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f59420g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59421h;

    public j() {
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
        this.f59414a = false;
    }
}
