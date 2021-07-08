package d.a.p0.i1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.OfficialFeedHeadResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class j implements CustomMessageTask.CustomRunnable<OfficialFeedHeadResponsedMessage.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f58698e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.i1.h.l f58699f;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58698e = 2001154;
        this.f58699f = d.a.p0.i1.h.l.t();
    }

    public final LoadHistoryResponsedMessage a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i2);
            loadHistoryResponsedMessage.setError(-18);
            return loadHistoryResponsedMessage;
        }
        return (LoadHistoryResponsedMessage) invokeI.objValue;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<OfficialFeedHeadResponsedMessage.a> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customMessage)) == null) {
            if (this.f58699f == null) {
                return a(this.f58698e);
            }
            List<d.a.p0.i1.h.o.a> u = d.a.p0.i1.h.l.u();
            if (u != null && u.size() > 0) {
                HashMap hashMap = new HashMap(u.size());
                for (d.a.p0.i1.h.o.a aVar : u) {
                    hashMap.put(aVar.b(), aVar);
                }
                LinkedList<ChatMessage> k = this.f58699f.k(hashMap, 80);
                if (k == null) {
                    return a(this.f58698e);
                }
                OfficialFeedHeadResponsedMessage.a aVar2 = new OfficialFeedHeadResponsedMessage.a();
                OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = new OfficialFeedHeadResponsedMessage(this.f58698e);
                aVar2.f17621b = k;
                aVar2.f17620a = u;
                try {
                    officialFeedHeadResponsedMessage.decodeInBackGround(2001105, aVar2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return officialFeedHeadResponsedMessage;
            }
            return a(this.f58698e);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
