package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AgreeList;
import tbclient.NewFloorInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes6.dex */
public class oa7 extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A;
    public static final BdUniqueId B;
    public static final BdUniqueId C;
    public static final BdUniqueId D;
    public static final BdUniqueId E;
    public static final BdUniqueId F;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public MetaData b;
    public String c;
    public long d;
    public String e;
    public String f;
    public OriginalThreadInfo g;
    public String h;
    public MetaData i;
    public int j;
    public String k;
    public String l;
    public long m;
    public long n;
    public boolean o;
    public String p;
    public MetaData q;
    public boolean r;
    public boolean s;
    public boolean t;
    public BaijiahaoData u;
    public String v;
    public int w;
    public String x;
    public List<NewFloorInfo> y;
    public TbRichText z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755446356, "Lcom/repackage/oa7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755446356, "Lcom/repackage/oa7;");
                return;
            }
        }
        A = BdUniqueId.gen();
        B = BdUniqueId.gen();
        C = BdUniqueId.gen();
        D = BdUniqueId.gen();
        E = BdUniqueId.gen();
        F = BdUniqueId.gen();
        BdUniqueId.gen();
    }

    public oa7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new MetaData();
        this.q = new MetaData();
        this.t = false;
        this.z = null;
    }

    public MetaData A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (MetaData) invokeV.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public MetaData D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (MetaData) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void H(FeedData feedData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, feedData) == null) || feedData == null) {
            return;
        }
        this.b = feedData.getReplyer();
        this.d = feedData.getTime();
        this.l = feedData.getPost_id();
        this.s = feedData.getHasAgree();
        if (!feedData.isHideForumName()) {
            this.h = feedData.getFname();
        }
        this.k = feedData.getThread_id();
        this.m = feedData.getFromForumId();
        this.j = feedData.getThread_Type();
        this.e = feedData.getContent();
        this.o = feedData.getIsFloor();
        this.c = feedData.getPostFrom();
        this.p = feedData.getQuote_pid();
        this.r = feedData.isNew();
        this.i = feedData.getThreadAuthor();
        this.t = feedData.isBjh();
        this.u = feedData.getBaijiahaoData();
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        this.g = originalThreadInfo;
        originalThreadInfo.f = this.k;
        originalThreadInfo.e = this.m;
        originalThreadInfo.k = this.j;
        originalThreadInfo.c = feedData.getThreadImgUrl();
        OriginalThreadInfo originalThreadInfo2 = this.g;
        originalThreadInfo2.o = this.t;
        originalThreadInfo2.p = this.u;
        this.y = feedData.getNewReplayInfo();
        this.w = feedData.getType();
        this.q = feedData.getQuote_user();
        if (feedData.getType() == 1) {
            this.g.n = feedData.getQuote_pid();
            if (feedData.getQuote_user() == null) {
                str = "";
            } else if (StringHelper.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a99);
            } else {
                str = feedData.getQuote_user().getName_show();
            }
            this.g.g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fc1, new Object[]{str, feedData.getQuote_content()});
            if (TextUtils.isGraphic(this.g.g)) {
                OriginalThreadInfo originalThreadInfo3 = this.g;
                originalThreadInfo3.g = originalThreadInfo3.g.replace("\n", " ");
            }
            if (feedData.getIsFloor()) {
                this.a = D;
            } else {
                this.a = E;
            }
        } else {
            this.g.n = "0";
            if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                this.g.g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1163, new Object[]{feedData.getOriginalThreadInfo().b});
            } else {
                this.g.g = feedData.getTitle();
            }
            this.a = F;
        }
        this.g.s();
    }

    public void I(AgreeList agreeList) {
        User user;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, agreeList) == null) || agreeList == null) {
            return;
        }
        this.n = agreeList.id.longValue();
        MetaData metaData = new MetaData();
        this.b = metaData;
        metaData.parserProtobuf(agreeList.agreeer);
        this.d = agreeList.time.intValue() * 1000;
        Post post = agreeList.post_info;
        if (post != null) {
            this.l = String.valueOf(post.id);
            if (!ListUtils.isEmpty(agreeList.post_info.content) && ListUtils.getItem(agreeList.post_info.content, 0) != null && (user = agreeList.post_info.author) != null) {
                String str = user.name_show;
                if (oi.isEmpty(str)) {
                    str = agreeList.post_info.author.name;
                }
                this.f = str + "：" + agreeList.post_info.content.get(0).text;
            }
            this.p = agreeList.post_info.quote_id;
        }
        ThreadData threadData = new ThreadData();
        threadData.parserProtobuf(agreeList.thread_info);
        this.g = OriginalThreadInfo.m(threadData);
        this.i = threadData.getAuthor();
        this.h = threadData.getForum_name();
        this.k = threadData.getId();
        this.m = threadData.getFid();
        this.j = threadData.threadType;
        this.t = threadData.isUgcThreadType();
        this.u = threadData.getBaijiahaoData();
        this.v = "c12927";
        if (agreeList.type.intValue() == 3) {
            this.a = A;
            this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00e4);
            if (this.t) {
                this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00e1);
            }
        } else if (agreeList.type.intValue() == 1) {
            this.a = B;
            this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00e3);
        } else if (agreeList.type.intValue() == 4) {
            this.a = C;
            this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00e2);
            String str2 = agreeList.virtual_image_url;
            this.x = str2;
            OriginalThreadInfo originalThreadInfo = this.g;
            originalThreadInfo.c = str2;
            originalThreadInfo.b = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b46);
            OriginalThreadInfo originalThreadInfo2 = this.g;
            originalThreadInfo2.a = 5;
            originalThreadInfo2.k = 70;
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.r = z;
        }
    }

    public void K(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbRichText) == null) {
            this.z = tbRichText;
        }
    }

    public void L(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbRichText) == null) {
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.m : invokeV.longValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.u : (BaijiahaoData) invokeV.objValue;
    }

    public int getCardType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.w : invokeV.intValue;
    }

    public int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.j : invokeV.intValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.d : invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a : (BdUniqueId) invokeV.objValue;
    }

    public TbRichText i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.z : (TbRichText) invokeV.objValue;
    }

    public boolean isBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.n : invokeV.longValue;
    }

    public List<NewFloorInfo> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.y : (List) invokeV.objValue;
    }

    public OriginalThreadInfo o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.g : (OriginalThreadInfo) invokeV.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public MetaData x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.q : (MetaData) invokeV.objValue;
    }
}
