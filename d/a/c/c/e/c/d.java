package d.a.c.c.e.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f38656f = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public a f38657a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.c.e.c.j.c f38658b;

    /* renamed from: c  reason: collision with root package name */
    public e f38659c;

    /* renamed from: d  reason: collision with root package name */
    public int f38660d;

    /* renamed from: e  reason: collision with root package name */
    public SocketMessageTask f38661e;

    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public SocketResponsedMessage f38662a;

        /* renamed from: b  reason: collision with root package name */
        public e f38663b;
    }

    public d(d.a.c.c.e.c.j.c cVar, e eVar, a aVar, int i2) {
        this.f38657a = null;
        this.f38658b = null;
        this.f38659c = null;
        this.f38660d = 0;
        this.f38661e = null;
        this.f38658b = cVar;
        this.f38659c = eVar;
        this.f38657a = aVar;
        this.f38660d = i2;
        if (eVar != null) {
            try {
                this.f38661e = eVar.t();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f38661e == null) {
            this.f38661e = (SocketMessageTask) MessageManager.getInstance().findTask(this.f38658b.f38703a.b());
        }
        setTag(f38656f);
        setPriority(4);
        SocketMessageTask socketMessageTask = this.f38661e;
        if (socketMessageTask != null) {
            setKey(String.valueOf(socketMessageTask.getCmd()));
            setParallel(this.f38661e.getParallel());
        }
    }

    public static BdUniqueId e() {
        return f38656f;
    }

    public final void b(SocketResponsedMessage socketResponsedMessage) {
        if (this.f38657a != null) {
            boolean c2 = c(socketResponsedMessage, this.f38659c);
            b bVar = new b();
            bVar.f38662a = socketResponsedMessage;
            if (!c2) {
                bVar.f38663b = this.f38659c;
            }
            this.f38657a.a(bVar);
        }
    }

    public final boolean c(SocketResponsedMessage socketResponsedMessage, e eVar) {
        if (this.f38660d == 0 || eVar == null || socketResponsedMessage != null) {
            return true;
        }
        i.b("unpacker", eVar.k(), eVar.m() == null ? -1L : eVar.m().getClientLogID(), this.f38660d, "checkresponsedMessage", h.l, "ack cont responsed");
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
            d.a.c.c.e.c.j.c r2 = r1.f38658b
            r3 = 0
            if (r2 != 0) goto La
            return r3
        La:
            d.a.c.c.e.c.e r5 = r1.f38659c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            r6 = 0
            if (r5 == 0) goto L1b
            d.a.c.c.e.c.e r5 = r1.f38659c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L15
            long r8 = r5.m     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L15
            goto L1c
        L15:
            r35 = r0
            r2 = r3
            r0 = 0
            goto L289
        L1b:
            r8 = r6
        L1c:
            d.a.c.c.e.c.e r5 = r1.f38659c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            if (r5 == 0) goto L25
            d.a.c.c.e.c.e r5 = r1.f38659c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L15
            long r10 = r5.n     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L15
            goto L26
        L25:
            r10 = r6
        L26:
            long r12 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            d.a.c.c.e.c.j.c r5 = r1.f38658b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            d.a.c.c.e.c.j.a r5 = r5.f38703a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            int r5 = r5.b()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L284
            d.a.c.c.e.c.j.c r14 = r1.f38658b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27f
            d.a.c.c.e.c.j.a r14 = r14.f38703a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27f
            boolean r19 = r14.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27f
            d.a.c.c.e.c.j.c r14 = r1.f38658b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27f
            int r15 = r14.f38706d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27f
            d.a.c.c.e.c.j.b r14 = d.a.c.c.e.c.j.b.f()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27f
            d.a.c.c.e.c.j.c r2 = r1.f38658b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27f
            r14.d(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27f
            long r20 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L27a
            r14 = 301001(0x497c9, float:4.21792E-40)
            if (r5 != r14) goto L5a
            java.lang.String r0 = "frs"
        L52:
            r30 = r0
            goto L8a
        L55:
            r35 = r0
            r0 = r5
            goto L289
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
            if (r5 != r14) goto L7a
            java.lang.String r0 = "user_center"
            goto L52
        L7a:
            r14 = 303002(0x49f9a, float:4.24596E-40)
            if (r5 != r14) goto L82
            java.lang.String r0 = "person_center_post"
            goto L52
        L82:
            r14 = 309647(0x4b98f, float:4.33908E-40)
            if (r5 != r14) goto L52
            java.lang.String r0 = "person_center_dynamic"
            goto L52
        L8a:
            d.a.c.c.e.c.e r0 = r1.f38659c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            if (r0 == 0) goto Lcd
            d.a.c.c.e.c.e r0 = r1.f38659c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc8
            com.baidu.adp.framework.message.SocketMessage r0 = r0.m()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc8
            long r16 = r0.getStartTime()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc8
            d.a.c.c.e.c.e r14 = r1.f38659c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc8
            long r22 = r14.s()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc8
            long r16 = r22 - r16
            long r24 = r12 - r22
            int r14 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r14 <= 0) goto Lb6
            long r26 = r8 - r22
            int r14 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r14 < 0) goto Lb3
            long r6 = r10 - r22
            long r8 = r10 - r8
            long r10 = r12 - r10
            goto Lbc
        Lb3:
            r8 = r6
            r10 = r8
            goto Lba
        Lb6:
            r8 = r6
            r10 = r8
            r26 = r10
        Lba:
            r6 = r24
        Lbc:
            long r12 = r20 - r12
            r33 = r8
            r31 = r26
            r8 = r6
            r6 = r16
            r17 = r0
            goto Ld6
        Lc8:
            r0 = r5
        Lc9:
            r35 = r30
            goto L289
        Lcd:
            r17 = r3
            r8 = r6
            r10 = r8
            r12 = r10
            r31 = r12
            r33 = r31
        Ld6:
            int r0 = r2.f38705c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            if (r0 != 0) goto Le1
            int r0 = r2.f38706d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc8
            byte[] r14 = r2.f38704b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc8
            int r14 = r14.length     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc8
            if (r0 == r14) goto Le7
        Le1:
            int r0 = r2.f38706d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            if (r0 > 0) goto Leb
            r2.f38704b = r3     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> Lc8
        Le7:
            r0 = r3
            r16 = r15
            goto L14b
        Leb:
            d.a.c.c.e.c.j.c r0 = r1.f38658b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            d.a.c.c.e.c.j.a r0 = r0.f38703a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            boolean r0 = r0.e()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            if (r0 == 0) goto L132
            byte[] r0 = r2.f38704b     // Catch: java.lang.Exception -> L127
            int r14 = r2.f38705c     // Catch: java.lang.Exception -> L127
            byte r3 = d.a.c.c.e.c.j.a.f38693g     // Catch: java.lang.Exception -> L127
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0, r14, r3)     // Catch: java.lang.Exception -> L127
            short r0 = r0.getShort()     // Catch: java.lang.Exception -> L127
            byte r3 = d.a.c.c.e.c.j.a.f38693g     // Catch: java.lang.Exception -> L127
            int r3 = r3 + r0
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocateDirect(r0)     // Catch: java.lang.Exception -> L127
            byte[] r4 = r2.f38704b     // Catch: java.lang.Exception -> L127
            r16 = r15
            int r15 = r2.f38705c     // Catch: java.lang.Exception -> L127
            byte r18 = d.a.c.c.e.c.j.a.f38693g     // Catch: java.lang.Exception -> L127
            int r15 = r15 + r18
            java.nio.ByteBuffer r0 = r14.put(r4, r15, r0)     // Catch: java.lang.Exception -> L127
            byte[] r0 = r0.array()     // Catch: java.lang.Exception -> L127
            int r4 = r2.f38705c     // Catch: java.lang.Exception -> L127
            int r4 = r4 + r3
            r2.f38705c = r4     // Catch: java.lang.Exception -> L127
            int r4 = r2.f38706d     // Catch: java.lang.Exception -> L127
            int r4 = r4 - r3
            r2.f38706d = r4     // Catch: java.lang.Exception -> L127
            goto L135
        L127:
            com.baidu.adp.framework.client.socket.coder.CoderException r0 = new com.baidu.adp.framework.client.socket.coder.CoderException     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L12f
            int r3 = d.a.c.c.e.c.h.f38687d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L12f
            r0.<init>(r3)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L12f
            throw r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L12f
        L12f:
            r0 = r5
            goto L277
        L132:
            r16 = r15
            r0 = 0
        L135:
            int r3 = r2.f38706d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocateDirect(r3)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            byte[] r4 = r2.f38704b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            int r14 = r2.f38705c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            int r15 = r2.f38706d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            java.nio.ByteBuffer r3 = r3.put(r4, r14, r15)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            byte[] r3 = r3.array()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            r2.f38704b = r3     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
        L14b:
            d.a.c.c.e.c.j.b r14 = d.a.c.c.e.c.j.b.f()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            byte[] r3 = r2.f38704b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            com.baidu.adp.framework.task.SocketMessageTask r4 = r1.f38661e     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L275
            r35 = r2
            r2 = r16
            r15 = r5
            r16 = r3
            r18 = r4
            com.baidu.adp.framework.message.SocketResponsedMessage r3 = r14.b(r15, r16, r17, r18, r19)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L271
            if (r3 == 0) goto L199
            if (r0 == 0) goto L199
            r3.decodeExtraDataInBackGround(r5, r0)     // Catch: java.lang.Exception -> L168
            goto L199
        L168:
            d.a.c.e.r.h r0 = d.a.c.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L194
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L194
            r17 = 0
            r18 = 0
            d.a.c.e.r.h r0 = d.a.c.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L194
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L194
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r14 = r30
            r15 = r5
            d.a.c.e.n.j.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L194
            com.baidu.adp.framework.client.socket.coder.CoderException r0 = new com.baidu.adp.framework.client.socket.coder.CoderException     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L194
            int r2 = d.a.c.c.e.c.h.f38687d     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L194
            r0.<init>(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L194
            throw r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L194
        L194:
            r0 = r5
            r2 = r35
            goto Lc9
        L199:
            long r14 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26b
            long r14 = r14 - r20
            if (r3 == 0) goto L241
            d.a.c.c.e.c.e r0 = r1.f38659c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26b
            if (r0 == 0) goto L1e4
            d.a.c.c.e.c.j.c r0 = r1.f38658b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1dc
            if (r0 == 0) goto L1e4
            long r16 = java.lang.System.currentTimeMillis()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1dc
            d.a.c.c.e.c.e r0 = r1.f38659c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1dc
            long r18 = r0.s()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1dc
            r36 = r5
            long r4 = r16 - r18
            r3.setCostTime(r4)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            d.a.c.c.e.c.e r0 = r1.f38659c     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            int r0 = r0.o()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            r3.setRetry(r0)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            d.a.c.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            r0.f38734a = r6     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            d.a.c.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            r0.f38736c = r8     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            d.a.c.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            r6 = r31
            r0.f38737d = r6     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            d.a.c.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            r4 = r33
            r0.f38738e = r4     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            d.a.c.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            r0.f38741h = r10     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L1de
            goto L1ea
        L1dc:
            r36 = r5
        L1de:
            r2 = r35
            r0 = r36
            goto Lc9
        L1e4:
            r36 = r5
            r6 = r31
            r4 = r33
        L1ea:
            r3.setDownSize(r2)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23c
            d.a.c.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23c
            r0.f38740g = r14     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23c
            d.a.c.c.i.a r0 = r3.performanceData     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23c
            r0.f38739f = r12     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23c
            d.a.c.c.e.c.j.c r0 = r1.f38658b     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23c
            d.a.c.c.e.c.j.a r0 = r0.f38703a     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23c
            int r0 = r0.h()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23c
            long r10 = (long) r0     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23c
            r3.sequenceID = r10     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L23c
            r2 = r35
            byte[] r0 = r2.f38704b     // Catch: java.lang.Exception -> L20c
            r10 = r36
            r3.beforeDispatchInBackGround(r10, r0)     // Catch: java.lang.Exception -> L20a
            goto L216
        L20a:
            r0 = move-exception
            goto L20f
        L20c:
            r0 = move-exception
            r10 = r36
        L20f:
            java.lang.String r0 = r0.getMessage()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
            com.baidu.adp.lib.util.BdLog.e(r0)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
        L216:
            d.a.c.e.r.h r0 = d.a.c.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
            r17 = 1
            r18 = 0
            d.a.c.e.r.h r0 = d.a.c.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
            r29 = 0
            r11 = r14
            r14 = r30
            r15 = r10
            r21 = r8
            r23 = r11
            r25 = r6
            r27 = r4
            d.a.c.e.n.j.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
            goto L268
        L23c:
            r2 = r35
            r10 = r36
            goto L26e
        L241:
            r10 = r5
            r2 = r35
            d.a.c.e.r.h r0 = d.a.c.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
            java.lang.String r16 = r0.q()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
            r17 = 0
            r18 = 0
            d.a.c.e.r.h r0 = d.a.c.e.r.h.j()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
            long r19 = r0.g()     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r14 = r30
            r15 = r10
            d.a.c.e.n.j.a.a(r14, r15, r16, r17, r18, r19, r21, r23, r25, r27, r29)     // Catch: com.baidu.adp.framework.client.socket.coder.CoderException -> L26e
        L268:
            r5 = r10
            goto L2ff
        L26b:
            r10 = r5
            r2 = r35
        L26e:
            r0 = r10
            goto Lc9
        L271:
            r10 = r5
            r2 = r35
            goto L276
        L275:
            r10 = r5
        L276:
            r0 = r10
        L277:
            r35 = r30
            goto L288
        L27a:
            r10 = r5
            r35 = r0
            r0 = r10
            goto L288
        L27f:
            r10 = r5
            r35 = r0
            r0 = r10
            goto L287
        L284:
            r35 = r0
            r0 = 0
        L287:
            r2 = 0
        L288:
            r3 = 0
        L289:
            r4 = -100
            d.a.c.c.e.c.e r6 = r1.f38659c
            if (r6 == 0) goto L29f
            com.baidu.adp.framework.message.SocketMessage r6 = r6.m()
            if (r6 == 0) goto L29f
            d.a.c.c.e.c.e r4 = r1.f38659c
            com.baidu.adp.framework.message.SocketMessage r4 = r4.m()
            long r4 = r4.getClientLogID()
        L29f:
            r12 = r4
            com.baidu.adp.lib.stats.BdStatisticsManager r6 = com.baidu.adp.lib.stats.BdStatisticsManager.getInstance()
            int r4 = r1.f38660d
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
            int r5 = r1.f38660d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r11[r4] = r5
            java.lang.String r7 = "im"
            r8 = r12
            r6.error(r7, r8, r10, r11)
            int r8 = r1.f38660d
            int r10 = d.a.c.c.e.c.h.k
            java.lang.String r4 = "unpacker"
            java.lang.String r9 = "unpacktask"
            java.lang.String r11 = "onBinaryMesssage decodebody error"
            r5 = r0
            r6 = r12
            d.a.c.c.e.c.i.b(r4, r5, r6, r8, r9, r10, r11)
            d.a.c.e.r.h r4 = d.a.c.e.r.h.j()
            java.lang.String r37 = r4.q()
            r38 = 0
            r39 = 0
            d.a.c.e.r.h r4 = d.a.c.e.r.h.j()
            long r40 = r4.g()
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r36 = r0
            d.a.c.e.n.j.a.a(r35, r36, r37, r38, r39, r40, r42, r44, r46, r48, r50)
        L2ff:
            if (r3 == 0) goto L308
            long r6 = java.lang.System.currentTimeMillis()
            r3.setStartTime(r6)
        L308:
            r4 = 1
            com.baidu.adp.framework.message.SocketResponsedMessage[] r0 = new com.baidu.adp.framework.message.SocketResponsedMessage[r4]
            r4 = 0
            r0[r4] = r3
            r1.publishProgress(r0)
            if (r3 == 0) goto L321
            byte[] r0 = r2.f38704b     // Catch: java.lang.Exception -> L319
            r3.afterDispatchInBackGround(r5, r0)     // Catch: java.lang.Exception -> L319
            goto L321
        L319:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.baidu.adp.lib.util.BdLog.e(r0)
        L321:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.c.c.e.c.d.doInBackground(java.lang.String[]):com.baidu.adp.framework.message.SocketResponsedMessage");
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
