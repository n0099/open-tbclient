package d.a.q0.e1.k.b.c;

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
    public long f56353a;

    /* renamed from: b  reason: collision with root package name */
    public long f56354b;

    /* renamed from: c  reason: collision with root package name */
    public long f56355c;

    /* renamed from: d  reason: collision with root package name */
    public a f56356d;

    /* renamed from: e  reason: collision with root package name */
    public a f56357e;

    /* renamed from: f  reason: collision with root package name */
    public int f56358f;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f56359a;

        /* renamed from: b  reason: collision with root package name */
        public String f56360b;

        /* renamed from: c  reason: collision with root package name */
        public String f56361c;

        /* renamed from: d  reason: collision with root package name */
        public String f56362d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f56363e;

        /* renamed from: f  reason: collision with root package name */
        public long f56364f;

        /* renamed from: g  reason: collision with root package name */
        public String f56365g;

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
        this.f56354b = pkModule.pk_id.longValue();
        this.f56355c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f56356d = aVar;
        aVar.f56359a = pkModule.agree.pk_num.longValue();
        this.f56356d.f56360b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f56356d;
        PkItem pkItem = pkModule.agree;
        aVar2.f56361c = pkItem.last_username;
        aVar2.f56362d = pkItem.pk_icon;
        aVar2.f56363e = pkItem.has_clicked.longValue() == 1;
        this.f56356d.f56364f = pkModule.agree.pk_index.longValue();
        this.f56356d.f56365g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f56357e = aVar3;
        aVar3.f56359a = pkModule.disagree.pk_num.longValue();
        this.f56357e.f56360b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f56357e;
        PkItem pkItem2 = pkModule.disagree;
        aVar4.f56361c = pkItem2.last_username;
        aVar4.f56362d = pkItem2.pk_icon;
        aVar4.f56363e = pkItem2.has_clicked.longValue() == 1;
        this.f56357e.f56364f = pkModule.disagree.pk_index.longValue();
        this.f56357e.f56365g = pkModule.disagree.pk_icon_after;
    }

    public void b(tbclient.NewTopicList.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f56354b = pkModule.pk_id.longValue();
        this.f56355c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f56356d = aVar;
        aVar.f56359a = pkModule.agree.pk_num.longValue();
        this.f56356d.f56360b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f56356d;
        tbclient.NewTopicList.PkItem pkItem = pkModule.agree;
        aVar2.f56361c = pkItem.last_username;
        aVar2.f56362d = pkItem.pk_icon;
        aVar2.f56363e = pkItem.has_clicked.longValue() == 1;
        this.f56356d.f56364f = pkModule.agree.pk_index.longValue();
        this.f56356d.f56365g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f56357e = aVar3;
        aVar3.f56359a = pkModule.disagree.pk_num.longValue();
        this.f56357e.f56360b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f56357e;
        tbclient.NewTopicList.PkItem pkItem2 = pkModule.disagree;
        aVar4.f56361c = pkItem2.last_username;
        aVar4.f56362d = pkItem2.pk_icon;
        aVar4.f56363e = pkItem2.has_clicked.longValue() == 1;
        this.f56357e.f56364f = pkModule.disagree.pk_index.longValue();
        this.f56357e.f56365g = pkModule.disagree.pk_icon_after;
    }

    public void c(tbclient.PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        this.f56354b = pkModule.pk_id.longValue();
        this.f56355c = pkModule.user_pk_id.longValue();
        a aVar = new a(this);
        this.f56356d = aVar;
        aVar.f56359a = pkModule.agree.pk_num.longValue();
        this.f56356d.f56360b = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
        a aVar2 = this.f56356d;
        tbclient.PkItem pkItem = pkModule.agree;
        aVar2.f56361c = pkItem.last_username;
        aVar2.f56362d = pkItem.pk_icon;
        aVar2.f56363e = pkItem.has_clicked.longValue() == 1;
        this.f56356d.f56364f = pkModule.agree.pk_index.longValue();
        this.f56356d.f56365g = pkModule.agree.pk_icon_after;
        a aVar3 = new a(this);
        this.f56357e = aVar3;
        aVar3.f56359a = pkModule.disagree.pk_num.longValue();
        this.f56357e.f56360b = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
        a aVar4 = this.f56357e;
        tbclient.PkItem pkItem2 = pkModule.disagree;
        aVar4.f56361c = pkItem2.last_username;
        aVar4.f56362d = pkItem2.pk_icon;
        aVar4.f56363e = pkItem2.has_clicked.longValue() == 1;
        this.f56357e.f56364f = pkModule.disagree.pk_index.longValue();
        this.f56357e.f56365g = pkModule.disagree.pk_icon_after;
    }
}
