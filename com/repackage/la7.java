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
public class la7 extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A;
    public static final BdUniqueId B;
    public static final BdUniqueId x;
    public static final BdUniqueId y;
    public static final BdUniqueId z;
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
    public boolean n;
    public String o;
    public MetaData p;
    public boolean q;
    public boolean r;
    public BaijiahaoData s;
    public String t;
    public int u;
    public List<NewFloorInfo> v;
    public TbRichText w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755535729, "Lcom/repackage/la7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755535729, "Lcom/repackage/la7;");
                return;
            }
        }
        x = BdUniqueId.gen();
        y = BdUniqueId.gen();
        z = BdUniqueId.gen();
        A = BdUniqueId.gen();
        B = BdUniqueId.gen();
    }

    public la7() {
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
        this.p = new MetaData();
        this.r = false;
        this.w = null;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public MetaData B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.i : (MetaData) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void F(FeedData feedData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, feedData) == null) || feedData == null) {
            return;
        }
        this.b = feedData.getReplyer();
        this.d = feedData.getTime();
        this.l = feedData.getPost_id();
        if (!feedData.isHideForumName()) {
            this.h = feedData.getFname();
        }
        this.k = feedData.getThread_id();
        this.j = feedData.getThread_Type();
        this.e = feedData.getContent();
        this.n = feedData.getIsFloor();
        this.c = feedData.getPostFrom();
        this.o = feedData.getQuote_pid();
        this.q = feedData.isNew();
        this.i = feedData.getThreadAuthor();
        this.r = feedData.isBjh();
        this.s = feedData.getBaijiahaoData();
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        this.g = originalThreadInfo;
        originalThreadInfo.f = this.k;
        originalThreadInfo.k = this.j;
        originalThreadInfo.c = feedData.getThreadImgUrl();
        OriginalThreadInfo originalThreadInfo2 = this.g;
        originalThreadInfo2.o = this.r;
        originalThreadInfo2.p = this.s;
        this.v = feedData.getNewReplayInfo();
        this.u = feedData.getType();
        this.p = feedData.getQuote_user();
        if (feedData.getType() == 1) {
            this.g.n = feedData.getQuote_pid();
            if (feedData.getQuote_user() == null) {
                str = "";
            } else if (StringHelper.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a99);
            } else {
                str = feedData.getQuote_user().getName_show();
            }
            this.g.g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f95, new Object[]{str, feedData.getQuote_content()});
            if (TextUtils.isGraphic(this.g.g)) {
                OriginalThreadInfo originalThreadInfo3 = this.g;
                originalThreadInfo3.g = originalThreadInfo3.g.replace("\n", " ");
            }
            if (feedData.getIsFloor()) {
                this.a = z;
            } else {
                this.a = A;
            }
        } else {
            this.g.n = "0";
            if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                this.g.g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1134, new Object[]{feedData.getOriginalThreadInfo().b});
            } else {
                this.g.g = feedData.getTitle();
            }
            this.a = B;
        }
        this.g.r();
    }

    public void G(AgreeList agreeList) {
        User user;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, agreeList) == null) || agreeList == null) {
            return;
        }
        this.m = agreeList.id.longValue();
        MetaData metaData = new MetaData();
        this.b = metaData;
        metaData.parserProtobuf(agreeList.agreeer);
        this.d = agreeList.time.intValue() * 1000;
        Post post = agreeList.post_info;
        if (post != null) {
            this.l = String.valueOf(post.id);
            if (!ListUtils.isEmpty(agreeList.post_info.content) && ListUtils.getItem(agreeList.post_info.content, 0) != null && (user = agreeList.post_info.author) != null) {
                String str = user.name_show;
                if (ni.isEmpty(str)) {
                    str = agreeList.post_info.author.name;
                }
                this.f = str + "：" + agreeList.post_info.content.get(0).text;
            }
            this.o = agreeList.post_info.quote_id;
        }
        ThreadData threadData = new ThreadData();
        threadData.parserProtobuf(agreeList.thread_info);
        this.g = OriginalThreadInfo.l(threadData);
        this.i = threadData.getAuthor();
        this.h = threadData.getForum_name();
        this.k = threadData.getId();
        this.j = threadData.threadType;
        this.r = threadData.isUgcThreadType();
        this.s = threadData.getBaijiahaoData();
        this.t = "c12927";
        if (agreeList.type.intValue() == 3) {
            this.a = x;
            this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00e0);
            if (this.r) {
                this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00de);
                return;
            }
            return;
        }
        this.a = y;
        this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00df);
    }

    public void H(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) {
            this.q = z2;
        }
    }

    public void I(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichText) == null) {
            this.w = tbRichText;
        }
    }

    public void J(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbRichText) == null) {
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public TbRichText g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w : (TbRichText) invokeV.objValue;
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.s : (BaijiahaoData) invokeV.objValue;
    }

    public int getCardType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.u : invokeV.intValue;
    }

    public int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.intValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.d : invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.uo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a : (BdUniqueId) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.m : invokeV.longValue;
    }

    public boolean isBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public List<NewFloorInfo> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.v : (List) invokeV.objValue;
    }

    public OriginalThreadInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.g : (OriginalThreadInfo) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public MetaData v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.p : (MetaData) invokeV.objValue;
    }

    public MetaData y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.b : (MetaData) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.t : (String) invokeV.objValue;
    }
}
