package d.a.q0.j1.b.p;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
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
import d.a.d.e.p.k;
import d.a.p0.s.q.b2;
import tbclient.AgreeList;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes8.dex */
public class a extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A;
    public static final BdUniqueId B;
    public static final BdUniqueId x;
    public static final BdUniqueId y;
    public static final BdUniqueId z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f59681e;

    /* renamed from: f  reason: collision with root package name */
    public MetaData f59682f;

    /* renamed from: g  reason: collision with root package name */
    public String f59683g;

    /* renamed from: h  reason: collision with root package name */
    public long f59684h;

    /* renamed from: i  reason: collision with root package name */
    public String f59685i;
    public String j;
    public OriginalThreadInfo k;
    public String l;
    public MetaData m;
    public int n;
    public String o;
    public String p;
    public long q;
    public boolean r;
    public String s;
    public boolean t;
    public boolean u;
    public BaijiahaoData v;
    public String w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1102494301, "Ld/a/q0/j1/b/p/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1102494301, "Ld/a/q0/j1/b/p/a;");
                return;
            }
        }
        x = BdUniqueId.gen();
        y = BdUniqueId.gen();
        z = BdUniqueId.gen();
        A = BdUniqueId.gen();
        B = BdUniqueId.gen();
    }

    public a() {
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
        this.f59682f = new MetaData();
        this.u = false;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public void D(FeedData feedData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, feedData) == null) || feedData == null) {
            return;
        }
        this.f59682f = feedData.getReplyer();
        this.f59684h = feedData.getTime();
        this.p = feedData.getPost_id();
        if (!feedData.isHideForumName()) {
            this.l = feedData.getFname();
        }
        this.o = feedData.getThread_id();
        this.n = feedData.getThread_Type();
        this.f59685i = feedData.getContent();
        this.r = feedData.getIsFloor();
        this.f59683g = feedData.getPostFrom();
        this.s = feedData.getQuote_pid();
        this.t = feedData.isNew();
        this.m = feedData.getThreadAuthor();
        this.u = feedData.isBjh();
        this.v = feedData.getBaijiahaoData();
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        this.k = originalThreadInfo;
        originalThreadInfo.f12282f = this.o;
        originalThreadInfo.k = this.n;
        originalThreadInfo.f12279c = feedData.getThreadImgUrl();
        OriginalThreadInfo originalThreadInfo2 = this.k;
        originalThreadInfo2.o = this.u;
        originalThreadInfo2.p = this.v;
        this.w = "c12928";
        if (feedData.getType() == 1) {
            this.k.n = feedData.getQuote_pid();
            if (feedData.getQuote_user() == null) {
                str = "";
            } else if (StringHelper.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                str = TbadkCoreApplication.getInst().getString(R.string.me);
            } else {
                str = feedData.getQuote_user().getName_show();
            }
            this.k.f12283g = TbadkCoreApplication.getInst().getString(R.string.reply_me_original, new Object[]{str, feedData.getQuote_content()});
            if (TextUtils.isGraphic(this.k.f12283g)) {
                OriginalThreadInfo originalThreadInfo3 = this.k;
                originalThreadInfo3.f12283g = originalThreadInfo3.f12283g.replace("\n", " ");
            }
            if (feedData.getIsFloor()) {
                this.f59681e = z;
            } else {
                this.f59681e = A;
            }
        } else {
            this.k.n = "0";
            if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                this.k.f12283g = TbadkCoreApplication.getInst().getString(R.string.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().f12278b});
            } else {
                this.k.f12283g = feedData.getTitle();
            }
            this.f59681e = B;
        }
        this.k.n();
    }

    public void E(AgreeList agreeList) {
        User user;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, agreeList) == null) || agreeList == null) {
            return;
        }
        this.q = agreeList.id.longValue();
        MetaData metaData = new MetaData();
        this.f59682f = metaData;
        metaData.parserProtobuf(agreeList.agreeer);
        this.f59684h = agreeList.time.intValue() * 1000;
        Post post = agreeList.post_info;
        if (post != null) {
            this.p = String.valueOf(post.id);
            if (!ListUtils.isEmpty(agreeList.post_info.content) && ListUtils.getItem(agreeList.post_info.content, 0) != null && (user = agreeList.post_info.author) != null) {
                String str = user.name_show;
                if (k.isEmpty(str)) {
                    str = agreeList.post_info.author.name;
                }
                this.j = str + "：" + agreeList.post_info.content.get(0).text;
            }
            this.s = agreeList.post_info.quote_id;
        }
        b2 b2Var = new b2();
        b2Var.K2(agreeList.thread_info);
        this.k = OriginalThreadInfo.i(b2Var);
        this.m = b2Var.H();
        this.l = b2Var.X();
        this.o = b2Var.d0();
        this.n = b2Var.Z;
        this.u = b2Var.r2();
        this.v = b2Var.J();
        this.w = "c12927";
        if (agreeList.type.intValue() == 3) {
            this.f59681e = x;
            this.f59685i = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_thread);
            if (this.u) {
                this.f59685i = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_dynamic);
                return;
            }
            return;
        }
        this.f59681e = y;
        this.f59685i = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_post);
    }

    public void F(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z2) == null) {
            this.t = z2;
        }
    }

    public BaijiahaoData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.v : (BaijiahaoData) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f59685i : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f59681e : (BdUniqueId) invokeV.objValue;
    }

    public OriginalThreadInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : (OriginalThreadInfo) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f59683g : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public MetaData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f59682f : (MetaData) invokeV.objValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public MetaData x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.m : (MetaData) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f59684h : invokeV.longValue;
    }
}
