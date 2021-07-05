package d.a.r0.r.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.MultiForumPerm;
/* loaded from: classes9.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f55926a;

    /* renamed from: b  reason: collision with root package name */
    public int f55927b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55928c;

    public e0() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f55926a = jSONObject.optInt("is_bawu") == 1;
        this.f55927b = "manager".equals(jSONObject.optString("bawu_type")) ? 1 : PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(jSONObject.optString("bawu_type")) ? 2 : 0;
        this.f55928c = jSONObject.optInt("is_deleted") == 1;
    }

    public void b(MultiForumPerm multiForumPerm) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, multiForumPerm) == null) || multiForumPerm == null) {
            return;
        }
        this.f55926a = multiForumPerm.is_bawu.intValue() == 1;
        this.f55927b = "manager".equals(multiForumPerm.bawu_type) ? 1 : PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(multiForumPerm.bawu_type) ? 2 : 0;
        this.f55928c = multiForumPerm.is_deleted.intValue() == 1;
    }
}
