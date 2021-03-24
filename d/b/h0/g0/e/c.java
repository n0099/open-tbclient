package d.b.h0.g0.e;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import d.b.b.e.d.l;
import d.b.b.e.p.p;
import d.b.h0.g0.b.c;
import d.b.h0.g0.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c<T extends d.b.h0.g0.b.c> extends a<T> {
    public c(int i, String str, Class<T> cls) {
        super(i, str, cls);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x00d3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:94:0x0070 */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v11. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v8. Raw type applied. Possible types: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        String str;
        String str2;
        List<l.b<String>> b2;
        ?? arrayList;
        String str3;
        d.b.h0.g0.b.c cVar;
        byte[] bArr;
        d.b.h0.g0.b.c cVar2;
        d.b.h0.g0.b.c cVar3 = null;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        d.b.h0.g0.b.c cVar4 = (d.b.h0.g0.b.c) a();
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
                            if (cVar4 instanceof d.b.h0.g0.b.b) {
                                List<l.b<byte[]>> a2 = p.a(d.b.h0.r.r.a.f().e(this.f50208f, str));
                                if (a2 != null) {
                                    arrayList = new ArrayList(a2.size());
                                    for (l.b<byte[]> bVar : a2) {
                                        if (bVar != null && (bArr = bVar.f41701b) != null && (cVar2 = (d.b.h0.g0.b.c) a()) != null) {
                                            ((d.b.h0.g0.b.b) cVar2).initByByteArray(bArr);
                                            arrayList.add(cVar2);
                                        }
                                    }
                                    cVar3 = arrayList;
                                }
                            } else if ((cVar4 instanceof e) && (b2 = p.b(d.b.h0.r.r.a.f().h(this.f50208f, str))) != null) {
                                arrayList = new ArrayList(b2.size());
                                for (l.b<String> bVar2 : b2) {
                                    if (bVar2 != null && (str3 = bVar2.f41701b) != null && (cVar = (d.b.h0.g0.b.c) a()) != null) {
                                        ((e) cVar).a(str3);
                                        arrayList.add(cVar);
                                    }
                                }
                                cVar3 = arrayList;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cVar3 = cVar4;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.f50210e, cVar3);
                        } catch (Throwable unused) {
                            cVar3 = cVar4;
                            return new ReadCacheRespMsg(this.f50210e, cVar3);
                        }
                    } else {
                        String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                        String q = readCacheMessage.getRequestData().q();
                        try {
                            if (cVar4 instanceof d.b.h0.g0.b.b) {
                                byte[] bArr2 = d.b.h0.r.r.a.f().e(q, str).get(cacheKey);
                                if (bArr2 != null) {
                                    ((d.b.h0.g0.b.b) cVar4).initByByteArray(bArr2);
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(cVar4);
                                    q = arrayList2;
                                    cVar3 = q;
                                }
                            } else if ((cVar4 instanceof e) && (str2 = d.b.h0.r.r.a.f().h(q, str).get(cacheKey)) != null) {
                                ((e) cVar4).a(str2);
                                ?? arrayList3 = new ArrayList();
                                arrayList3.add(cVar4);
                                q = arrayList3;
                                cVar3 = q;
                            }
                        } catch (Exception e3) {
                            cVar3 = q;
                            e = e3;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.f50210e, cVar3);
                        } catch (Throwable unused2) {
                            cVar3 = q;
                            return new ReadCacheRespMsg(this.f50210e, cVar3);
                        }
                    }
                }
                return new ReadCacheRespMsg(this.f50210e, cVar3);
            } catch (Throwable unused3) {
            }
        } catch (Exception e4) {
            e = e4;
        }
    }
}
