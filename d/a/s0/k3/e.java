package d.a.s0.k3;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.g;
import d.a.r0.r.q.k1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62733a;

    public e(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62733a = tbPageContext;
        MessageManager.getInstance().registerStickyMode(2921453);
    }

    public void a(Intent intent, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, intent, dVar) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.PUSH_DES_PAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            String string = this.f62733a.getString(R.string.des_page_home_recommend);
            k1 k1Var = new k1();
            Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME));
            int i2 = 1;
            if (matcher.find()) {
                k1Var.f55998c = matcher.group(1);
            }
            if (stringExtra.equals(string)) {
                k1Var.f55996a = 1;
            } else {
                k1Var.f55996a = 2;
                k1Var.f55997b = stringExtra;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921453, k1Var));
            if (stringExtra.equals(string)) {
                intent.putExtra("sub_locate_type", 1);
                i2 = 2;
            } else {
                intent.putExtra("sub_locate_type", stringExtra);
            }
            if (dVar != null && dVar.C() != null) {
                dVar.C().setCurrentTabByType(i2);
                FragmentTabHost.b g2 = dVar.C().g(i2);
                if (g2 != null) {
                    Fragment fragment = g2.f12348c;
                    if (fragment instanceof g) {
                        ((g) fragment).x0(intent);
                    }
                }
            }
        }
        intent.removeExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
        intent.removeExtra(MainTabActivityConfig.PUSH_DES_PAGE);
    }

    public boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) ? intent.getIntExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION, 0) == 1 : invokeL.booleanValue;
    }
}
