package com.repackage;

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
import com.repackage.o85;
import com.repackage.ue;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b95<T extends o85> extends z85<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b95(int i, String str, Class<T> cls) {
        super(i, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x0073 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x00d6 */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v12. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v9. Raw type applied. Possible types: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v36 */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        InterceptResult invokeL;
        String str;
        ?? arrayList;
        String str2;
        o85 o85Var;
        byte[] bArr;
        o85 o85Var2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
            return (CustomResponsedMessage) invokeL.objValue;
        }
        o85 o85Var3 = null;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        o85 o85Var4 = (o85) a();
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
                if (o85Var4 != null) {
                    if (readCacheMessage.getRequestData() == null) {
                        try {
                            if (o85Var4 instanceof n85) {
                                tr4.f();
                                List<ue.b<byte[]>> a = vi.a(tr4.e(this.b, str));
                                if (a != null) {
                                    arrayList = new ArrayList(a.size());
                                    for (ue.b<byte[]> bVar : a) {
                                        if (bVar != null && (bArr = bVar.b) != null && (o85Var2 = (o85) a()) != null) {
                                            ((n85) o85Var2).initByByteArray(bArr);
                                            arrayList.add(o85Var2);
                                        }
                                    }
                                    o85Var3 = arrayList;
                                }
                            } else if (o85Var4 instanceof q85) {
                                tr4.f();
                                List<ue.b<String>> b = vi.b(tr4.h(this.b, str));
                                if (b != null) {
                                    arrayList = new ArrayList(b.size());
                                    for (ue.b<String> bVar2 : b) {
                                        if (bVar2 != null && (str2 = bVar2.b) != null && (o85Var = (o85) a()) != null) {
                                            ((q85) o85Var).q(str2);
                                            arrayList.add(o85Var);
                                        }
                                    }
                                    o85Var3 = arrayList;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            o85Var3 = o85Var4;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.a, o85Var3);
                        } catch (Throwable th) {
                            th = th;
                            o85Var3 = o85Var4;
                            new ReadCacheRespMsg(this.a, o85Var3);
                            throw th;
                        }
                    } else {
                        String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                        String y = readCacheMessage.getRequestData().y();
                        try {
                            if (o85Var4 instanceof n85) {
                                tr4.f();
                                byte[] bArr2 = tr4.e(y, str).get(cacheKey);
                                if (bArr2 != null) {
                                    ((n85) o85Var4).initByByteArray(bArr2);
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(o85Var4);
                                    y = arrayList2;
                                    o85Var3 = y;
                                }
                            } else if (o85Var4 instanceof q85) {
                                tr4.f();
                                String str3 = tr4.h(y, str).get(cacheKey);
                                if (str3 != null) {
                                    ((q85) o85Var4).q(str3);
                                    ?? arrayList3 = new ArrayList();
                                    arrayList3.add(o85Var4);
                                    y = arrayList3;
                                    o85Var3 = y;
                                }
                            }
                        } catch (Exception e2) {
                            o85Var3 = y;
                            e = e2;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.a, o85Var3);
                        } catch (Throwable th2) {
                            o85Var3 = y;
                            th = th2;
                            new ReadCacheRespMsg(this.a, o85Var3);
                            throw th;
                        }
                    }
                }
                return new ReadCacheRespMsg(this.a, o85Var3);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
