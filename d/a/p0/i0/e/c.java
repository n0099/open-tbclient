package d.a.p0.i0.e;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.d.l;
import d.a.d.e.p.p;
import d.a.p0.i0.b.c;
import d.a.p0.i0.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c<T extends d.a.p0.i0.b.c> extends a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, String str, Class<T> cls) {
        super(i2, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x00d7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:99:0x0074 */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v11. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v8. Raw type applied. Possible types: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        InterceptResult invokeL;
        String str;
        String str2;
        List<l.b<String>> b2;
        ?? arrayList;
        String str3;
        d.a.p0.i0.b.c cVar;
        byte[] bArr;
        d.a.p0.i0.b.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
            return (CustomResponsedMessage) invokeL.objValue;
        }
        d.a.p0.i0.b.c cVar3 = null;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        d.a.p0.i0.b.c cVar4 = (d.a.p0.i0.b.c) a();
        try {
            try {
                if (readCacheMessage.isNeedUid()) {
                    str = TbadkCoreApplication.getCurrentAccount();
                    if (str == null) {
                        str = "";
                    }
                } else {
                    str = null;
                }
                if (cVar4 != null) {
                    if (readCacheMessage.getRequestData() == null) {
                        try {
                            if (cVar4 instanceof d.a.p0.i0.b.b) {
                                List<l.b<byte[]>> a2 = p.a(d.a.p0.s.r.a.f().e(this.f52681f, str));
                                if (a2 != null) {
                                    arrayList = new ArrayList(a2.size());
                                    for (l.b<byte[]> bVar : a2) {
                                        if (bVar != null && (bArr = bVar.f41627b) != null && (cVar2 = (d.a.p0.i0.b.c) a()) != null) {
                                            ((d.a.p0.i0.b.b) cVar2).initByByteArray(bArr);
                                            arrayList.add(cVar2);
                                        }
                                    }
                                    cVar3 = arrayList;
                                }
                            } else if ((cVar4 instanceof e) && (b2 = p.b(d.a.p0.s.r.a.f().h(this.f52681f, str))) != null) {
                                arrayList = new ArrayList(b2.size());
                                for (l.b<String> bVar2 : b2) {
                                    if (bVar2 != null && (str3 = bVar2.f41627b) != null && (cVar = (d.a.p0.i0.b.c) a()) != null) {
                                        ((e) cVar).n(str3);
                                        arrayList.add(cVar);
                                    }
                                }
                                cVar3 = arrayList;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cVar3 = cVar4;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.f52683e, cVar3);
                        } catch (Throwable unused) {
                            cVar3 = cVar4;
                            return new ReadCacheRespMsg(this.f52683e, cVar3);
                        }
                    } else {
                        String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                        String v = readCacheMessage.getRequestData().v();
                        try {
                            if (cVar4 instanceof d.a.p0.i0.b.b) {
                                byte[] bArr2 = d.a.p0.s.r.a.f().e(v, str).get(cacheKey);
                                if (bArr2 != null) {
                                    ((d.a.p0.i0.b.b) cVar4).initByByteArray(bArr2);
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(cVar4);
                                    v = arrayList2;
                                    cVar3 = v;
                                }
                            } else if ((cVar4 instanceof e) && (str2 = d.a.p0.s.r.a.f().h(v, str).get(cacheKey)) != null) {
                                ((e) cVar4).n(str2);
                                ?? arrayList3 = new ArrayList();
                                arrayList3.add(cVar4);
                                v = arrayList3;
                                cVar3 = v;
                            }
                        } catch (Exception e3) {
                            cVar3 = v;
                            e = e3;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.f52683e, cVar3);
                        } catch (Throwable unused2) {
                            cVar3 = v;
                            return new ReadCacheRespMsg(this.f52683e, cVar3);
                        }
                    }
                }
                return new ReadCacheRespMsg(this.f52683e, cVar3);
            } catch (Throwable unused3) {
            }
        } catch (Exception e4) {
            e = e4;
        }
    }
}
