package d.a.q0.j0.g;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import d.a.d.c.f.k;
import d.a.q0.j0.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f59468a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f59469b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f59470c;

    /* renamed from: d  reason: collision with root package name */
    public Gson f59471d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59471d = new Gson();
        a();
    }

    public final void a() {
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59469b = new SparseArray<>();
            ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
            if (ListUtils.isEmpty(findHttpTasks)) {
                return;
            }
            for (int i2 = 0; i2 < findHttpTasks.size(); i2++) {
                String url = findHttpTasks.get(i2).getUrl();
                if (!d.a.d.e.p.k.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!d.a.d.e.p.k.isEmpty(str) && str.contains("=") && (d2 = d.a.d.e.m.b.d(str.split("[=]")[1], 0)) != 0) {
                        this.f59469b.put(d2, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketMessage, socketMessageTask)) == null) {
            String str = this.f59469b.get(socketMessage.getCmd());
            if (str != null && (hashMap = this.f59470c) != null && hashMap.get(str) != null && this.f59468a != null) {
                this.f59468a.a(str, this.f59471d.toJson(this.f59470c.get(str)), this.f59471d.toJson(this.f59471d.toJson(socketMessage.getData())));
            }
            return socketMessage;
        }
        return (SocketMessage) invokeLL.objValue;
    }

    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f59468a = cVar;
        }
    }

    public void d(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hashMap) == null) {
            this.f59470c = hashMap;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // d.a.d.c.f.f
    public /* bridge */ /* synthetic */ SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        SocketMessage socketMessage2 = socketMessage;
        b(socketMessage2, socketMessageTask);
        return socketMessage2;
    }
}
