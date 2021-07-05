package d.a.s0.e2.d;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes9.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f59150e;

    /* renamed from: f  reason: collision with root package name */
    public int f59151f;

    /* renamed from: g  reason: collision with root package name */
    public String f59152g;

    /* renamed from: h  reason: collision with root package name */
    public String f59153h;

    /* renamed from: i  reason: collision with root package name */
    public long f59154i;
    public String j;
    public int k;

    public b(@NonNull NewTopicList newTopicList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newTopicList, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59151f = i2 + 1;
        this.f59152g = newTopicList.topic_name;
        this.f59153h = newTopicList.topic_desc;
        this.f59154i = newTopicList.discuss_num.longValue();
        this.j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f59150e = newTopicList.topic_id.longValue();
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f59149a : (BdUniqueId) invokeV.objValue;
    }
}
