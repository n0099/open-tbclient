package d.a.s0.g1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes9.dex */
public class n extends d.a.s0.a0.e0.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59704g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.n> f59705e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59706f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(760099985, "Ld/a/s0/g1/c/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(760099985, "Ld/a/s0/g1/c/n;");
                return;
            }
        }
        f59704g = BdUniqueId.gen();
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59705e = null;
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<d.a.c.k.e.n> list = this.f59705e;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f59705e.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f59704g : (BdUniqueId) invokeV.objValue;
    }

    public void parserProtobuf(List<RelateForum> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        this.showTopDivider = true;
        this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.recommend_relative_forum);
        this.f59705e = new ArrayList();
        for (RelateForum relateForum : list) {
            if (!StringUtils.isNull(relateForum.forum_name)) {
                RelateForumItemData relateForumItemData = new RelateForumItemData();
                relateForumItemData.parserProtobuf(relateForum);
                this.f59705e.add(relateForumItemData);
            }
        }
    }
}
