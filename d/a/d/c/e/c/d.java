package d.a.d.c.e.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f41405f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f41406a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.d.c.e.c.j.c f41407b;

    /* renamed from: c  reason: collision with root package name */
    public e f41408c;

    /* renamed from: d  reason: collision with root package name */
    public int f41409d;

    /* renamed from: e  reason: collision with root package name */
    public SocketMessageTask f41410e;

    /* loaded from: classes7.dex */
    public interface a {
        void a(b bVar);
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SocketResponsedMessage f41411a;

        /* renamed from: b  reason: collision with root package name */
        public e f41412b;

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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(685263593, "Ld/a/d/c/e/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(685263593, "Ld/a/d/c/e/c/d;");
                return;
            }
        }
        f41405f = BdUniqueId.gen();
    }

    public d(d.a.d.c.e.c.j.c cVar, e eVar, a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, eVar, aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41406a = null;
        this.f41407b = null;
        this.f41408c = null;
        this.f41409d = 0;
        this.f41410e = null;
        this.f41407b = cVar;
        this.f41408c = eVar;
        this.f41406a = aVar;
        this.f41409d = i2;
        if (eVar != null) {
            try {
                this.f41410e = eVar.t();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f41410e == null) {
            this.f41410e = (SocketMessageTask) MessageManager.getInstance().findTask(this.f41407b.f41452a.b());
        }
        setTag(f41405f);
        setPriority(4);
        SocketMessageTask socketMessageTask = this.f41410e;
        if (socketMessageTask != null) {
            setKey(String.valueOf(socketMessageTask.getCmd()));
            setParallel(this.f41410e.getParallel());
        }
    }

    public static BdUniqueId e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f41405f : (BdUniqueId) invokeV.objValue;
    }

    public final void b(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) || this.f41406a == null) {
            return;
        }
        boolean c2 = c(socketResponsedMessage, this.f41408c);
        b bVar = new b();
        bVar.f41411a = socketResponsedMessage;
        if (!c2) {
            bVar.f41412b = this.f41408c;
        }
        this.f41406a.a(bVar);
    }

    public final boolean c(SocketResponsedMessage socketResponsedMessage, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage, eVar)) == null) {
            if (this.f41409d == 0 || eVar == null || socketResponsedMessage != null) {
                return true;
            }
            i.b("unpacker", eVar.k(), eVar.m() == null ? -1L : eVar.m().getClientLogID(), this.f41409d, "checkresponsedMessage", h.l, "ack cont responsed");
            return false;
        }
        return invokeLL.booleanValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:26:0x0059
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.adp.framework.message.SocketResponsedMessage doInBackground(java.lang.String... r52) {
        /*
            r51 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = d.a.d.c.e.c.d.$ic
            if (r0 != 0) goto L327
        L4:
            r1 = r51
            java.lang.String r0 = "other"
            d.a.d.c.e.c.j.c r2 = r1.f41407b
            r3 = 0
            if (r2 != 0) goto Le
            return r3
        Le:
            d.a.d.c.e.c.e r5 = r1.f41408c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L288
            r6 = 0
            if (r5 == 0) goto L1f
            d.a.d.c.e.c.e r5 = r1.f41408c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L19
            long r8 = r5.m     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L19
            goto L20
        L19:
            r35 = r0
            r2 = r3
            r0 = 0
            goto L28d
        L1f:
            r8 = r6
        L20:
            d.a.d.c.e.c.e r5 = r1.f41408c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L288
            if (r5 == 0) goto L29
            d.a.d.c.e.c.e r5 = r1.f41408c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L19
            long r10 = r5.n     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L19
            goto L2a
        L29:
            r10 = r6
        L2a:
            long r12 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L288
            d.a.d.c.e.c.j.c r5 = r1.f41407b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L288
            d.a.d.c.e.c.j.a r5 = r5.f41452a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L288
            int r5 = r5.b()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L288
            d.a.d.c.e.c.j.c r14 = r1.f41407b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L283
            d.a.d.c.e.c.j.a r14 = r14.f41452a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L283
            boolean r19 = r14.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L283
            d.a.d.c.e.c.j.c r14 = r1.f41407b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L283
            int r15 = r14.f41455d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L283
            d.a.d.c.e.c.j.b r14 = d.a.d.c.e.c.j.b.f()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L283
            d.a.d.c.e.c.j.c r2 = r1.f41407b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L283
            r14.d(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L283
            long r20 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27e
            r14 = 301001(0x497c9, float:4.21792E-40)
            if (r5 != r14) goto L5e
            java.lang.String r0 = "frs"
        L56:
            r30 = r0
            goto L8e
        L59:
            r35 = r0
            r0 = r5
            goto L28d
        L5e:
            r14 = 302001(0x49bb1, float:4.23194E-40)
            if (r5 != r14) goto L66
            java.lang.String r0 = "pb"
            goto L56
        L66:
            r14 = 309264(0x4b810, float:4.33371E-40)
            if (r5 != r14) goto L6e
            java.lang.String r0 = "home_page"
            goto L56
        L6e:
            r14 = 303011(0x49fa3, float:4.24609E-40)
            if (r5 != r14) goto L76
            java.lang.String r0 = "enter_forum"
            goto L56
        L76:
            r14 = 303012(0x49fa4, float:4.2461E-40)
            if (r5 != r14) goto L7e
            java.lang.String r0 = "user_center"
            goto L56
        L7e:
            r14 = 303002(0x49f9a, float:4.24596E-40)
            if (r5 != r14) goto L86
            java.lang.String r0 = "person_center_post"
            goto L56
        L86:
            r14 = 309647(0x4b98f, float:4.33908E-40)
            if (r5 != r14) goto L56
            java.lang.String r0 = "person_center_dynamic"
            goto L56
        L8e:
            d.a.d.c.e.c.e r0 = r1.f41408c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            if (r0 == 0) goto Ld1
            d.a.d.c.e.c.e r0 = r1.f41408c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcc
            com.baidu.adp.framework.message.SocketMessage r0 = r0.m()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcc
            long r16 = r0.getStartTime()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcc
            d.a.d.c.e.c.e r14 = r1.f41408c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcc
            long r22 = r14.s()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcc
            long r16 = r22 - r16
            long r24 = r12 - r22
            int r14 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r14 <= 0) goto Lba
            long r26 = r8 - r22
            int r14 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r14 < 0) goto Lb7
            long r6 = r10 - r22
            long r8 = r10 - r8
            long r10 = r12 - r10
            goto Lc0
        Lb7:
            r8 = r6
            r10 = r8
            goto Lbe
        Lba:
            r8 = r6
            r10 = r8
            r26 = r10
        Lbe:
            r6 = r24
        Lc0:
            long r12 = r20 - r12
            r33 = r8
            r31 = r26
            r8 = r6
            r6 = r16
            r17 = r0
            goto Lda
        Lcc:
            r0 = r5
        Lcd:
            r35 = r30
            goto L28d
        Ld1:
            r17 = r3
            r8 = r6
            r10 = r8
            r12 = r10
            r31 = r12
            r33 = r31
        Lda:
            int r0 = r2.f41454c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            if (r0 != 0) goto Le5
            int r0 = r2.f41455d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcc
            byte[] r14 = r2.f41453b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcc
            int r14 = r14.length     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcc
            if (r0 == r14) goto Leb
        Le5:
            int r0 = r2.f41455d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            if (r0 > 0) goto Lef
            r2.f41453b = r3     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lcc
        Leb:
            r0 = r3
            r16 = r15
            goto L14f
        Lef:
            d.a.d.c.e.c.j.c r0 = r1.f41407b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            d.a.d.c.e.c.j.a r0 = r0.f41452a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            boolean r0 = r0.e()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            if (r0 == 0) goto L136
            byte[] r0 = r2.f41453b     // Catch: java.lang.Exception -> L12b
            int r14 = r2.f41454c     // Catch: java.lang.Exception -> L12b
            byte r3 = d.a.d.c.e.c.j.a.f41442g     // Catch: java.lang.Exception -> L12b
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0, r14, r3)     // Catch: java.lang.Exception -> L12b
            short r0 = r0.getShort()     // Catch: java.lang.Exception -> L12b
            byte r3 = d.a.d.c.e.c.j.a.f41442g     // Catch: java.lang.Exception -> L12b
            int r3 = r3 + r0
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocateDirect(r0)     // Catch: java.lang.Exception -> L12b
            byte[] r4 = r2.f41453b     // Catch: java.lang.Exception -> L12b
            r16 = r15
            int r15 = r2.f41454c     // Catch: java.lang.Exception -> L12b
            byte r18 = d.a.d.c.e.c.j.a.f41442g     // Catch: java.lang.Exception -> L12b
            int r15 = r15 + r18
            java.nio.ByteBuffer r0 = r14.put(r4, r15, r0)     // Catch: java.lang.Exception -> L12b
            byte[] r0 = r0.array()     // Catch: java.lang.Exception -> L12b
            int r4 = r2.f41454c     // Catch: java.lang.Exception -> L12b
            int r4 = r4 + r3
            r2.f41454c = r4     // Catch: java.lang.Exception -> L12b
            int r4 = r2.f41455d     // Catch: java.lang.Exception -> L12b
            int r4 = r4 - r3
            r2.f41455d = r4     // Catch: java.lang.Exception -> L12b
            goto L139
        L12b:
            com.baidu.adp.framework.client.socket.coder.CoderException r0 = new com.baidu.adp.framework.client.socket.coder.CoderException     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L133
            int r3 = d.a.d.c.e.c.h.f41436d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L133
            r0.<init>(r3)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L133
            throw r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L133
        L133:
            r0 = r5
            goto L27b
        L136:
            r16 = r15
            r0 = 0
        L139:
            int r3 = r2.f41455d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocateDirect(r3)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            byte[] r4 = r2.f41453b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            int r14 = r2.f41454c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            int r15 = r2.f41455d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            java.nio.ByteBuffer r3 = r3.put(r4, r14, r15)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            byte[] r3 = r3.array()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            r2.f41453b = r3     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
        L14f:
            d.a.d.c.e.c.j.b r14 = d.a.d.c.e.c.j.b.f()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            byte[] r3 = r2.f41453b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            com.baidu.adp.framework.task.SocketMessageTask r4 = r1.f41410e     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L279
            r35 = r2
            r2 = r16
            r15 = r5
            r16 = r3
            r18 = r4
            com.baidu.adp.framework.message.SocketResponsedMessage r3 = r14.b(r15, r16, r17, r18, r19)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            if (r3 == 0) goto L19d
            if (r0 == 0) goto L19d
            r3.decodeExtraDataInBackGround(r5, r0)     // Catch: java.lang.Exception -> L16c
            goto L19d
        L16c:
            d.a.d.e.r.h r0 = d.a.d.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L198
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L198
            r17 = 0
            r18 = 0
            d.a.d.e.r.h r0 = d.a.d.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L198
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L198
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r14 = r30
            r15 = r5
            d.a.d.e.n.l.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L198
            com.baidu.adp.framework.client.socket.coder.CoderException r0 = new com.baidu.adp.framework.client.socket.coder.CoderException     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L198
            int r2 = d.a.d.c.e.c.h.f41436d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L198
            r0.<init>(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L198
            throw r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L198
        L198:
            r0 = r5
            r2 = r35
            goto Lcd
        L19d:
            long r14 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            long r14 = r14 - r20
            if (r3 == 0) goto L245
            d.a.d.c.e.c.e r0 = r1.f41408c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            if (r0 == 0) goto L1e8
            d.a.d.c.e.c.j.c r0 = r1.f41407b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e0
            if (r0 == 0) goto L1e8
            long r16 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e0
            d.a.d.c.e.c.e r0 = r1.f41408c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e0
            long r18 = r0.s()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e0
            r36 = r5
            long r4 = r16 - r18
            r3.setCostTime(r4)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            d.a.d.c.e.c.e r0 = r1.f41408c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            int r0 = r0.o()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            r3.setRetry(r0)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            d.a.d.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            r0.f41483a = r6     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            d.a.d.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            r0.f41485c = r8     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            d.a.d.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            r6 = r31
            r0.f41486d = r6     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            d.a.d.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            r4 = r33
            r0.f41487e = r4     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            d.a.d.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            r0.f41490h = r10     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1e2
            goto L1ee
        L1e0:
            r36 = r5
        L1e2:
            r2 = r35
            r0 = r36
            goto Lcd
        L1e8:
            r36 = r5
            r6 = r31
            r4 = r33
        L1ee:
            r3.setDownSize(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L240
            d.a.d.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L240
            r0.f41489g = r14     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L240
            d.a.d.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L240
            r0.f41488f = r12     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L240
            d.a.d.c.e.c.j.c r0 = r1.f41407b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L240
            d.a.d.c.e.c.j.a r0 = r0.f41452a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L240
            int r0 = r0.h()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L240
            long r10 = (long) r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L240
            r3.sequenceID = r10     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L240
            r2 = r35
            byte[] r0 = r2.f41453b     // Catch: java.lang.Exception -> L210
            r10 = r36
            r3.beforeDispatchInBackGround(r10, r0)     // Catch: java.lang.Exception -> L20e
            goto L21a
        L20e:
            r0 = move-exception
            goto L213
        L210:
            r0 = move-exception
            r10 = r36
        L213:
            java.lang.String r0 = r0.getMessage()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            com.baidu.adp.lib.util.BdLog.e(r0)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
        L21a:
            d.a.d.e.r.h r0 = d.a.d.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            r17 = 1
            r18 = 0
            d.a.d.e.r.h r0 = d.a.d.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            r29 = 0
            r11 = r14
            r14 = r30
            r15 = r10
            r21 = r8
            r23 = r11
            r25 = r6
            r27 = r4
            d.a.d.e.n.l.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            goto L26c
        L240:
            r2 = r35
            r10 = r36
            goto L272
        L245:
            r10 = r5
            r2 = r35
            d.a.d.e.r.h r0 = d.a.d.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            r17 = 0
            r18 = 0
            d.a.d.e.r.h r0 = d.a.d.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r14 = r30
            r15 = r10
            d.a.d.e.n.l.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
        L26c:
            r5 = r10
            goto L303
        L26f:
            r10 = r5
            r2 = r35
        L272:
            r0 = r10
            goto Lcd
        L275:
            r10 = r5
            r2 = r35
            goto L27a
        L279:
            r10 = r5
        L27a:
            r0 = r10
        L27b:
            r35 = r30
            goto L28c
        L27e:
            r10 = r5
            r35 = r0
            r0 = r10
            goto L28c
        L283:
            r10 = r5
            r35 = r0
            r0 = r10
            goto L28b
        L288:
            r35 = r0
            r0 = 0
        L28b:
            r2 = 0
        L28c:
            r3 = 0
        L28d:
            r4 = -100
            d.a.d.c.e.c.e r6 = r1.f41408c
            if (r6 == 0) goto L2a3
            com.baidu.adp.framework.message.SocketMessage r6 = r6.m()
            if (r6 == 0) goto L2a3
            d.a.d.c.e.c.e r4 = r1.f41408c
            com.baidu.adp.framework.message.SocketMessage r4 = r4.m()
            long r4 = r4.getClientLogID()
        L2a3:
            r12 = r4
            com.baidu.adp.lib.stats.BdStatisticsManager r6 = com.baidu.adp.lib.stats.BdStatisticsManager.getInstance()
            int r4 = r1.f41409d
            java.lang.String r10 = java.lang.String.valueOf(r4)
            r4 = 4
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r4 = "cmd"
            r5 = 0
            r11[r5] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r5 = 1
            r11[r5] = r4
            r4 = 2
            java.lang.String r5 = "seqid"
            r11[r4] = r5
            r4 = 3
            int r5 = r1.f41409d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r11[r4] = r5
            java.lang.String r7 = "im"
            r8 = r12
            r6.error(r7, r8, r10, r11)
            int r8 = r1.f41409d
            int r10 = d.a.d.c.e.c.h.k
            java.lang.String r4 = "unpacker"
            java.lang.String r9 = "unpacktask"
            java.lang.String r11 = "onBinaryMesssage decodebody error"
            r5 = r0
            r6 = r12
            d.a.d.c.e.c.i.b(r4, r5, r6, r8, r9, r10, r11)
            d.a.d.e.r.h r4 = d.a.d.e.r.h.j()
            java.lang.String r37 = r4.q()
            r38 = 0
            r39 = 0
            d.a.d.e.r.h r4 = d.a.d.e.r.h.j()
            long r40 = r4.g()
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r36 = r0
            d.a.d.e.n.l.a.a(r35, r36, r37, r38, r39, r40, r42, r44, r46, r48, r50)
        L303:
            if (r3 == 0) goto L30c
            long r6 = java.lang.System.currentTimeMillis()
            r3.setStartTime(r6)
        L30c:
            r4 = 1
            com.baidu.adp.framework.message.SocketResponsedMessage[] r0 = new com.baidu.adp.framework.message.SocketResponsedMessage[r4]
            r4 = 0
            r0[r4] = r3
            r1.publishProgress(r0)
            if (r3 == 0) goto L325
            byte[] r0 = r2.f41453b     // Catch: java.lang.Exception -> L31d
            r3.afterDispatchInBackGround(r5, r0)     // Catch: java.lang.Exception -> L31d
            goto L325
        L31d:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.baidu.adp.lib.util.BdLog.e(r0)
        L325:
            r2 = 0
            return r2
        L327:
            r49 = r0
            r50 = 1048578(0x100002, float:1.469371E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r49.invokeL(r50, r51, r52)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.baidu.adp.framework.message.SocketResponsedMessage r1 = (com.baidu.adp.framework.message.SocketResponsedMessage) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.d.c.e.c.d.doInBackground(java.lang.String[]):com.baidu.adp.framework.message.SocketResponsedMessage");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public void onProgressUpdate(SocketResponsedMessage... socketResponsedMessageArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, socketResponsedMessageArr) == null) {
            if (socketResponsedMessageArr != null && socketResponsedMessageArr.length > 0) {
                b(socketResponsedMessageArr[0]);
            } else {
                b(null);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onCancelled();
            b(null);
        }
    }
}
