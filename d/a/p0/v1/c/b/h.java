package d.a.p0.v1.c.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h(VipThemeItem vipThemeItem) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipThemeItem};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str = vipThemeItem.img_url;
        String str2 = vipThemeItem.title;
        vipThemeItem.props_id.intValue();
        vipThemeItem.props_category.intValue();
        String str3 = vipThemeItem.props_category_name;
        String str4 = vipThemeItem.desc;
        String str5 = vipThemeItem.link;
        String str6 = vipThemeItem.tag_img_url;
        String str7 = vipThemeItem.update_time;
        vipThemeItem.id.intValue();
        vipThemeItem.type.intValue();
    }
}
