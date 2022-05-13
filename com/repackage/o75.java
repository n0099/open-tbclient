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
import com.repackage.a75;
import com.repackage.qe;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o75<T extends a75> extends m75<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o75(int i, String str, Class<T> cls) {
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
        a75 a75Var;
        byte[] bArr;
        a75 a75Var2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
            return (CustomResponsedMessage) invokeL.objValue;
        }
        a75 a75Var3 = null;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        a75 a75Var4 = (a75) a();
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
                if (a75Var4 != null) {
                    if (readCacheMessage.getRequestData() == null) {
                        try {
                            if (a75Var4 instanceof z65) {
                                mr4.f();
                                List<qe.b<byte[]>> a = ri.a(mr4.e(this.b, str));
                                if (a != null) {
                                    arrayList = new ArrayList(a.size());
                                    for (qe.b<byte[]> bVar : a) {
                                        if (bVar != null && (bArr = bVar.b) != null && (a75Var2 = (a75) a()) != null) {
                                            ((z65) a75Var2).initByByteArray(bArr);
                                            arrayList.add(a75Var2);
                                        }
                                    }
                                    a75Var3 = arrayList;
                                }
                            } else if (a75Var4 instanceof c75) {
                                mr4.f();
                                List<qe.b<String>> b = ri.b(mr4.h(this.b, str));
                                if (b != null) {
                                    arrayList = new ArrayList(b.size());
                                    for (qe.b<String> bVar2 : b) {
                                        if (bVar2 != null && (str2 = bVar2.b) != null && (a75Var = (a75) a()) != null) {
                                            ((c75) a75Var).p(str2);
                                            arrayList.add(a75Var);
                                        }
                                    }
                                    a75Var3 = arrayList;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            a75Var3 = a75Var4;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.a, a75Var3);
                        } catch (Throwable th) {
                            th = th;
                            a75Var3 = a75Var4;
                            new ReadCacheRespMsg(this.a, a75Var3);
                            throw th;
                        }
                    } else {
                        String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                        String x = readCacheMessage.getRequestData().x();
                        try {
                            if (a75Var4 instanceof z65) {
                                mr4.f();
                                byte[] bArr2 = mr4.e(x, str).get(cacheKey);
                                if (bArr2 != null) {
                                    ((z65) a75Var4).initByByteArray(bArr2);
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(a75Var4);
                                    x = arrayList2;
                                    a75Var3 = x;
                                }
                            } else if (a75Var4 instanceof c75) {
                                mr4.f();
                                String str3 = mr4.h(x, str).get(cacheKey);
                                if (str3 != null) {
                                    ((c75) a75Var4).p(str3);
                                    ?? arrayList3 = new ArrayList();
                                    arrayList3.add(a75Var4);
                                    x = arrayList3;
                                    a75Var3 = x;
                                }
                            }
                        } catch (Exception e2) {
                            a75Var3 = x;
                            e = e2;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.a, a75Var3);
                        } catch (Throwable th2) {
                            a75Var3 = x;
                            th = th2;
                            new ReadCacheRespMsg(this.a, a75Var3);
                            throw th;
                        }
                    }
                }
                return new ReadCacheRespMsg(this.a, a75Var3);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
