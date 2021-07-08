package d.a.p0.e1.k.b.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.PkItem;
import tbclient.NewHottopic.PkModule;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f55809a;

    /* renamed from: b  reason: collision with root package name */
    public long f55810b;

    /* renamed from: c  reason: collision with root package name */
    public long f55811c;

    /* renamed from: d  reason: collision with root package name */
    public a f55812d;

    /* renamed from: e  reason: collision with root package name */
    public a f55813e;

    /* renamed from: f  reason: collision with root package name */
    public int f55814f;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f55815a;

        /* renamed from: b  reason: collision with root package name */
        public String f55816b;

        /* renamed from: c  reason: collision with root package name */
        public String f55817c;

        /* renamed from: d  reason: collision with root package name */
        public String f55818d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f55819e;

        /* renamed from: f  reason: collision with root package name */
        public long f55820f;

        /* renamed from: g  reason: collision with root package name */
        public String f55821g;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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

    public b() {
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

    public void a(PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f55810b = pkModule.pk_id.longValue();
        this.f55811c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f55812d = aVar;
        aVar.f55815a = pkModule.agree.pk_num.longValue();
        this.f55812d.f55816b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f55812d;
        PkItem pkItem = pkModule.agree;
        aVar2.f55817c = pkItem.last_username;
        aVar2.f55818d = pkItem.pk_icon;
        aVar2.f55819e = pkItem.has_clicked.longValue() == 1;
        this.f55812d.f55820f = pkModule.agree.pk_index.longValue();
        this.f55812d.f55821g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f55813e = aVar3;
        aVar3.f55815a = pkModule.disagree.pk_num.longValue();
        this.f55813e.f55816b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f55813e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f55817c = pkItem2.last_username;
        aVar4.f55818d = pkItem2.pk_icon;
        aVar4.f55819e = pkItem2.has_clicked.longValue() == 1;
        this.f55813e.f55820f = pkModule.disagree.pk_index.longValue();
        this.f55813e.f55821g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f55810b = pkModule.pk_id.longValue();
        this.f55811c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f55812d = aVar;
        aVar.f55815a = pkModule.agree.pk_num.longValue();
        this.f55812d.f55816b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f55812d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f55817c = pkItem.last_username;
        aVar2.f55818d = pkItem.pk_icon;
        aVar2.f55819e = pkItem.has_clicked.longValue() == 1;
        this.f55812d.f55820f = pkModule.agree.pk_index.longValue();
        this.f55812d.f55821g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f55813e = aVar3;
        aVar3.f55815a = pkModule.disagree.pk_num.longValue();
        this.f55813e.f55816b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f55813e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f55817c = pkItem2.last_username;
        aVar4.f55818d = pkItem2.pk_icon;
        aVar4.f55819e = pkItem2.has_clicked.longValue() == 1;
        this.f55813e.f55820f = pkModule.disagree.pk_index.longValue();
        this.f55813e.f55821g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f55810b = pkModule.pk_id.longValue();
        this.f55811c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f55812d = aVar;
        aVar.f55815a = pkModule.agree.pk_num.longValue();
        this.f55812d.f55816b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f55812d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f55817c = pkItem.last_username;
        aVar2.f55818d = pkItem.pk_icon;
        aVar2.f55819e = pkItem.has_clicked.longValue() == 1;
        this.f55812d.f55820f = pkModule.agree.pk_index.longValue();
        this.f55812d.f55821g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f55813e = aVar3;
        aVar3.f55815a = pkModule.disagree.pk_num.longValue();
        this.f55813e.f55816b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f55813e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f55817c = pkItem2.last_username;
        aVar4.f55818d = pkItem2.pk_icon;
        aVar4.f55819e = pkItem2.has_clicked.longValue() == 1;
        this.f55813e.f55820f = pkModule.disagree.pk_index.longValue();
        this.f55813e.f55821g = pkModule.disagree.pk_icon_after;
    }
}
