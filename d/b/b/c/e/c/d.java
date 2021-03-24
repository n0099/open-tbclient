package d.b.b.c.e.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f41488f = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public a f41489a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.c.e.c.j.c f41490b;

    /* renamed from: c  reason: collision with root package name */
    public e f41491c;

    /* renamed from: d  reason: collision with root package name */
    public int f41492d;

    /* renamed from: e  reason: collision with root package name */
    public SocketMessageTask f41493e;

    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public SocketResponsedMessage f41494a;

        /* renamed from: b  reason: collision with root package name */
        public e f41495b;
    }

    public d(d.b.b.c.e.c.j.c cVar, e eVar, a aVar, int i) {
        this.f41489a = null;
        this.f41490b = null;
        this.f41491c = null;
        this.f41492d = 0;
        this.f41493e = null;
        this.f41490b = cVar;
        this.f41491c = eVar;
        this.f41489a = aVar;
        this.f41492d = i;
        if (eVar != null) {
            try {
                this.f41493e = eVar.t();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f41493e == null) {
            this.f41493e = (SocketMessageTask) MessageManager.getInstance().findTask(this.f41490b.f41531a.b());
        }
        setTag(f41488f);
        setPriority(4);
        SocketMessageTask socketMessageTask = this.f41493e;
        if (socketMessageTask != null) {
            setKey(String.valueOf(socketMessageTask.getCmd()));
            setParallel(this.f41493e.getParallel());
        }
    }

    public static BdUniqueId e() {
        return f41488f;
    }

    public final void b(SocketResponsedMessage socketResponsedMessage) {
        if (this.f41489a != null) {
            boolean c2 = c(socketResponsedMessage, this.f41491c);
            b bVar = new b();
            bVar.f41494a = socketResponsedMessage;
            if (!c2) {
                bVar.f41495b = this.f41491c;
            }
            this.f41489a.a(bVar);
        }
    }

    public final boolean c(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.f41492d == 0 || eVar == null || socketResponsedMessage != null) {
            return true;
        }
        i.b("unpacker", eVar.k(), eVar.m() == null ? -1L : eVar.m().getClientLogID(), this.f41492d, "checkresponsedMessage", h.l, "ack cont responsed");
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:24:0x0055
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
            r1 = r51
            java.lang.String r0 = "other"
            d.b.b.c.e.c.j.c r2 = r1.f41490b
            r3 = 0
            if (r2 != 0) goto La
            return r3
        La:
            d.b.b.c.e.c.e r5 = r1.f41491c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L285
            r6 = 0
            if (r5 == 0) goto L1b
            d.b.b.c.e.c.e r5 = r1.f41491c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L15
            long r8 = r5.m     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L15
            goto L1c
        L15:
            r35 = r0
            r2 = r3
            r0 = 0
            goto L28a
        L1b:
            r8 = r6
        L1c:
            d.b.b.c.e.c.e r5 = r1.f41491c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L285
            if (r5 == 0) goto L25
            d.b.b.c.e.c.e r5 = r1.f41491c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L15
            long r10 = r5.n     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L15
            goto L26
        L25:
            r10 = r6
        L26:
            long r12 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L285
            d.b.b.c.e.c.j.c r5 = r1.f41490b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L285
            d.b.b.c.e.c.j.a r5 = r5.f41531a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L285
            int r5 = r5.b()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L285
            d.b.b.c.e.c.j.c r14 = r1.f41490b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L280
            d.b.b.c.e.c.j.a r14 = r14.f41531a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L280
            boolean r19 = r14.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L280
            d.b.b.c.e.c.j.c r14 = r1.f41490b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L280
            int r15 = r14.f41534d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L280
            d.b.b.c.e.c.j.b r14 = d.b.b.c.e.c.j.b.f()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L280
            d.b.b.c.e.c.j.c r2 = r1.f41490b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L280
            r14.d(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L280
            long r20 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27b
            r14 = 301001(0x497c9, float:4.21792E-40)
            if (r5 != r14) goto L5a
            java.lang.String r0 = "frs"
        L52:
            r30 = r0
            goto L8b
        L55:
            r35 = r0
            r0 = r5
            goto L28a
        L5a:
            r14 = 302001(0x49bb1, float:4.23194E-40)
            if (r5 != r14) goto L62
            java.lang.String r0 = "pb"
            goto L52
        L62:
            r14 = 309264(0x4b810, float:4.33371E-40)
            if (r5 != r14) goto L6a
            java.lang.String r0 = "home_page"
            goto L52
        L6a:
            r14 = 303011(0x49fa3, float:4.24609E-40)
            if (r5 != r14) goto L72
            java.lang.String r0 = "enter_forum"
            goto L52
        L72:
            r14 = 303012(0x49fa4, float:4.2461E-40)
            if (r5 != r14) goto L7b
            java.lang.String r0 = "user_center"
            goto L52
        L7b:
            r14 = 303002(0x49f9a, float:4.24596E-40)
            if (r5 != r14) goto L83
            java.lang.String r0 = "person_center_post"
            goto L52
        L83:
            r14 = 309647(0x4b98f, float:4.33908E-40)
            if (r5 != r14) goto L52
            java.lang.String r0 = "person_center_dynamic"
            goto L52
        L8b:
            d.b.b.c.e.c.e r0 = r1.f41491c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            if (r0 == 0) goto Lce
            d.b.b.c.e.c.e r0 = r1.f41491c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc9
            com.baidu.adp.framework.message.SocketMessage r0 = r0.m()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc9
            long r16 = r0.getStartTime()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc9
            d.b.b.c.e.c.e r14 = r1.f41491c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc9
            long r22 = r14.s()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc9
            long r16 = r22 - r16
            long r24 = r12 - r22
            int r14 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r14 <= 0) goto Lb7
            long r26 = r8 - r22
            int r14 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r14 < 0) goto Lb4
            long r6 = r10 - r22
            long r8 = r10 - r8
            long r10 = r12 - r10
            goto Lbd
        Lb4:
            r8 = r6
            r10 = r8
            goto Lbb
        Lb7:
            r8 = r6
            r10 = r8
            r26 = r10
        Lbb:
            r6 = r24
        Lbd:
            long r12 = r20 - r12
            r33 = r8
            r31 = r26
            r8 = r6
            r6 = r16
            r17 = r0
            goto Ld7
        Lc9:
            r0 = r5
        Lca:
            r35 = r30
            goto L28a
        Lce:
            r17 = r3
            r8 = r6
            r10 = r8
            r12 = r10
            r31 = r12
            r33 = r31
        Ld7:
            int r0 = r2.f41533c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            if (r0 != 0) goto Le2
            int r0 = r2.f41534d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc9
            byte[] r14 = r2.f41532b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc9
            int r14 = r14.length     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc9
            if (r0 == r14) goto Le8
        Le2:
            int r0 = r2.f41534d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            if (r0 > 0) goto Lec
            r2.f41532b = r3     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc9
        Le8:
            r0 = r3
            r16 = r15
            goto L14c
        Lec:
            d.b.b.c.e.c.j.c r0 = r1.f41490b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            d.b.b.c.e.c.j.a r0 = r0.f41531a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            boolean r0 = r0.e()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            if (r0 == 0) goto L133
            byte[] r0 = r2.f41532b     // Catch: java.lang.Exception -> L128
            int r14 = r2.f41533c     // Catch: java.lang.Exception -> L128
            byte r3 = d.b.b.c.e.c.j.a.f41522g     // Catch: java.lang.Exception -> L128
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0, r14, r3)     // Catch: java.lang.Exception -> L128
            short r0 = r0.getShort()     // Catch: java.lang.Exception -> L128
            byte r3 = d.b.b.c.e.c.j.a.f41522g     // Catch: java.lang.Exception -> L128
            int r3 = r3 + r0
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocateDirect(r0)     // Catch: java.lang.Exception -> L128
            byte[] r4 = r2.f41532b     // Catch: java.lang.Exception -> L128
            r16 = r15
            int r15 = r2.f41533c     // Catch: java.lang.Exception -> L128
            byte r18 = d.b.b.c.e.c.j.a.f41522g     // Catch: java.lang.Exception -> L128
            int r15 = r15 + r18
            java.nio.ByteBuffer r0 = r14.put(r4, r15, r0)     // Catch: java.lang.Exception -> L128
            byte[] r0 = r0.array()     // Catch: java.lang.Exception -> L128
            int r4 = r2.f41533c     // Catch: java.lang.Exception -> L128
            int r4 = r4 + r3
            r2.f41533c = r4     // Catch: java.lang.Exception -> L128
            int r4 = r2.f41534d     // Catch: java.lang.Exception -> L128
            int r4 = r4 - r3
            r2.f41534d = r4     // Catch: java.lang.Exception -> L128
            goto L136
        L128:
            com.baidu.adp.framework.client.socket.coder.CoderException r0 = new com.baidu.adp.framework.client.socket.coder.CoderException     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L130
            int r3 = d.b.b.c.e.c.h.f41517d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L130
            r0.<init>(r3)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L130
            throw r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L130
        L130:
            r0 = r5
            goto L278
        L133:
            r16 = r15
            r0 = 0
        L136:
            int r3 = r2.f41534d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocateDirect(r3)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            byte[] r4 = r2.f41532b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            int r14 = r2.f41533c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            int r15 = r2.f41534d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            java.nio.ByteBuffer r3 = r3.put(r4, r14, r15)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            byte[] r3 = r3.array()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            r2.f41532b = r3     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
        L14c:
            d.b.b.c.e.c.j.b r14 = d.b.b.c.e.c.j.b.f()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            byte[] r3 = r2.f41532b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            com.baidu.adp.framework.task.SocketMessageTask r4 = r1.f41493e     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L276
            r35 = r2
            r2 = r16
            r15 = r5
            r16 = r3
            r18 = r4
            com.baidu.adp.framework.message.SocketResponsedMessage r3 = r14.b(r15, r16, r17, r18, r19)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L272
            if (r3 == 0) goto L19a
            if (r0 == 0) goto L19a
            r3.decodeExtraDataInBackGround(r5, r0)     // Catch: java.lang.Exception -> L169
            goto L19a
        L169:
            d.b.b.e.r.h r0 = d.b.b.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L195
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L195
            r17 = 0
            r18 = 0
            d.b.b.e.r.h r0 = d.b.b.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L195
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L195
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r14 = r30
            r15 = r5
            d.b.b.e.n.j.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L195
            com.baidu.adp.framework.client.socket.coder.CoderException r0 = new com.baidu.adp.framework.client.socket.coder.CoderException     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L195
            int r2 = d.b.b.c.e.c.h.f41517d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L195
            r0.<init>(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L195
            throw r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L195
        L195:
            r0 = r5
            r2 = r35
            goto Lca
        L19a:
            long r14 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26c
            long r14 = r14 - r20
            if (r3 == 0) goto L242
            d.b.b.c.e.c.e r0 = r1.f41491c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26c
            if (r0 == 0) goto L1e5
            d.b.b.c.e.c.j.c r0 = r1.f41490b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1dd
            if (r0 == 0) goto L1e5
            long r16 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1dd
            d.b.b.c.e.c.e r0 = r1.f41491c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1dd
            long r18 = r0.s()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1dd
            r36 = r5
            long r4 = r16 - r18
            r3.setCostTime(r4)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            d.b.b.c.e.c.e r0 = r1.f41491c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            int r0 = r0.o()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            r3.setRetry(r0)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            d.b.b.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            r0.f41559a = r6     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            d.b.b.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            r0.f41561c = r8     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            d.b.b.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            r6 = r31
            r0.f41562d = r6     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            d.b.b.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            r4 = r33
            r0.f41563e = r4     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            d.b.b.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            r0.f41566h = r10     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1df
            goto L1eb
        L1dd:
            r36 = r5
        L1df:
            r2 = r35
            r0 = r36
            goto Lca
        L1e5:
            r36 = r5
            r6 = r31
            r4 = r33
        L1eb:
            r3.setDownSize(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23d
            d.b.b.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23d
            r0.f41565g = r14     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23d
            d.b.b.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23d
            r0.f41564f = r12     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23d
            d.b.b.c.e.c.j.c r0 = r1.f41490b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23d
            d.b.b.c.e.c.j.a r0 = r0.f41531a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23d
            int r0 = r0.h()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23d
            long r10 = (long) r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23d
            r3.sequenceID = r10     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23d
            r2 = r35
            byte[] r0 = r2.f41532b     // Catch: java.lang.Exception -> L20d
            r10 = r36
            r3.beforeDispatchInBackGround(r10, r0)     // Catch: java.lang.Exception -> L20b
            goto L217
        L20b:
            r0 = move-exception
            goto L210
        L20d:
            r0 = move-exception
            r10 = r36
        L210:
            java.lang.String r0 = r0.getMessage()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            com.baidu.adp.lib.util.BdLog.e(r0)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
        L217:
            d.b.b.e.r.h r0 = d.b.b.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            r17 = 1
            r18 = 0
            d.b.b.e.r.h r0 = d.b.b.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            r29 = 0
            r11 = r14
            r14 = r30
            r15 = r10
            r21 = r8
            r23 = r11
            r25 = r6
            r27 = r4
            d.b.b.e.n.j.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            goto L269
        L23d:
            r2 = r35
            r10 = r36
            goto L26f
        L242:
            r10 = r5
            r2 = r35
            d.b.b.e.r.h r0 = d.b.b.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            r17 = 0
            r18 = 0
            d.b.b.e.r.h r0 = d.b.b.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r14 = r30
            r15 = r10
            d.b.b.e.n.j.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26f
        L269:
            r5 = r10
            goto L303
        L26c:
            r10 = r5
            r2 = r35
        L26f:
            r0 = r10
            goto Lca
        L272:
            r10 = r5
            r2 = r35
            goto L277
        L276:
            r10 = r5
        L277:
            r0 = r10
        L278:
            r35 = r30
            goto L289
        L27b:
            r10 = r5
            r35 = r0
            r0 = r10
            goto L289
        L280:
            r10 = r5
            r35 = r0
            r0 = r10
            goto L288
        L285:
            r35 = r0
            r0 = 0
        L288:
            r2 = 0
        L289:
            r3 = 0
        L28a:
            r4 = -100
            d.b.b.c.e.c.e r6 = r1.f41491c
            if (r6 == 0) goto L2a0
            com.baidu.adp.framework.message.SocketMessage r6 = r6.m()
            if (r6 == 0) goto L2a0
            d.b.b.c.e.c.e r4 = r1.f41491c
            com.baidu.adp.framework.message.SocketMessage r4 = r4.m()
            long r4 = r4.getClientLogID()
        L2a0:
            r12 = r4
            com.baidu.adp.lib.stats.BdStatisticsManager r6 = com.baidu.adp.lib.stats.BdStatisticsManager.getInstance()
            int r4 = r1.f41492d
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
            int r5 = r1.f41492d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r11[r4] = r5
            java.lang.String r7 = "im"
            r8 = r12
            r6.error(r7, r8, r10, r11)
            int r8 = r1.f41492d
            int r10 = d.b.b.c.e.c.h.k
            java.lang.String r4 = "unpacker"
            java.lang.String r9 = "unpacktask"
            java.lang.String r11 = "onBinaryMesssage decodebody error"
            r5 = r0
            r6 = r12
            d.b.b.c.e.c.i.b(r4, r5, r6, r8, r9, r10, r11)
            d.b.b.e.r.h r4 = d.b.b.e.r.h.j()
            java.lang.String r37 = r4.q()
            r38 = 0
            r39 = 0
            d.b.b.e.r.h r4 = d.b.b.e.r.h.j()
            long r40 = r4.g()
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r36 = r0
            d.b.b.e.n.j.a.a(r35, r36, r37, r38, r39, r40, r42, r44, r46, r48, r50)
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
            byte[] r0 = r2.f41532b     // Catch: java.lang.Exception -> L31d
            r3.afterDispatchInBackGround(r5, r0)     // Catch: java.lang.Exception -> L31d
            goto L325
        L31d:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.baidu.adp.lib.util.BdLog.e(r0)
        L325:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.b.c.e.c.d.doInBackground(java.lang.String[]):com.baidu.adp.framework.message.SocketResponsedMessage");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public void onProgressUpdate(SocketResponsedMessage... socketResponsedMessageArr) {
        if (socketResponsedMessageArr != null && socketResponsedMessageArr.length > 0) {
            b(socketResponsedMessageArr[0]);
        } else {
            b(null);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        b(null);
    }
}
