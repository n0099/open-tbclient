package d.a.s0.e1.k.b.c;

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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f59064a;

    /* renamed from: b  reason: collision with root package name */
    public long f59065b;

    /* renamed from: c  reason: collision with root package name */
    public long f59066c;

    /* renamed from: d  reason: collision with root package name */
    public a f59067d;

    /* renamed from: e  reason: collision with root package name */
    public a f59068e;

    /* renamed from: f  reason: collision with root package name */
    public int f59069f;

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f59070a;

        /* renamed from: b  reason: collision with root package name */
        public String f59071b;

        /* renamed from: c  reason: collision with root package name */
        public String f59072c;

        /* renamed from: d  reason: collision with root package name */
        public String f59073d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f59074e;

        /* renamed from: f  reason: collision with root package name */
        public long f59075f;

        /* renamed from: g  reason: collision with root package name */
        public String f59076g;

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
        this.f59065b = pkModule.pk_id.longValue();
        this.f59066c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f59067d = aVar;
        aVar.f59070a = pkModule.agree.pk_num.longValue();
        this.f59067d.f59071b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f59067d;
        PkItem pkItem = pkModule.agree;
        aVar2.f59072c = pkItem.last_username;
        aVar2.f59073d = pkItem.pk_icon;
        aVar2.f59074e = pkItem.has_clicked.longValue() == 1;
        this.f59067d.f59075f = pkModule.agree.pk_index.longValue();
        this.f59067d.f59076g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f59068e = aVar3;
        aVar3.f59070a = pkModule.disagree.pk_num.longValue();
        this.f59068e.f59071b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f59068e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f59072c = pkItem2.last_username;
        aVar4.f59073d = pkItem2.pk_icon;
        aVar4.f59074e = pkItem2.has_clicked.longValue() == 1;
        this.f59068e.f59075f = pkModule.disagree.pk_index.longValue();
        this.f59068e.f59076g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f59065b = pkModule.pk_id.longValue();
        this.f59066c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f59067d = aVar;
        aVar.f59070a = pkModule.agree.pk_num.longValue();
        this.f59067d.f59071b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f59067d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f59072c = pkItem.last_username;
        aVar2.f59073d = pkItem.pk_icon;
        aVar2.f59074e = pkItem.has_clicked.longValue() == 1;
        this.f59067d.f59075f = pkModule.agree.pk_index.longValue();
        this.f59067d.f59076g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f59068e = aVar3;
        aVar3.f59070a = pkModule.disagree.pk_num.longValue();
        this.f59068e.f59071b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f59068e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f59072c = pkItem2.last_username;
        aVar4.f59073d = pkItem2.pk_icon;
        aVar4.f59074e = pkItem2.has_clicked.longValue() == 1;
        this.f59068e.f59075f = pkModule.disagree.pk_index.longValue();
        this.f59068e.f59076g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f59065b = pkModule.pk_id.longValue();
        this.f59066c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f59067d = aVar;
        aVar.f59070a = pkModule.agree.pk_num.longValue();
        this.f59067d.f59071b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f59067d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f59072c = pkItem.last_username;
        aVar2.f59073d = pkItem.pk_icon;
        aVar2.f59074e = pkItem.has_clicked.longValue() == 1;
        this.f59067d.f59075f = pkModule.agree.pk_index.longValue();
        this.f59067d.f59076g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f59068e = aVar3;
        aVar3.f59070a = pkModule.disagree.pk_num.longValue();
        this.f59068e.f59071b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f59068e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f59072c = pkItem2.last_username;
        aVar4.f59073d = pkItem2.pk_icon;
        aVar4.f59074e = pkItem2.has_clicked.longValue() == 1;
        this.f59068e.f59075f = pkModule.disagree.pk_index.longValue();
        this.f59068e.f59076g = pkModule.disagree.pk_icon_after;
    }
}
