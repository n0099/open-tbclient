package d.a.n0.f0.i;

import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import com.squareup.wire.Wire;
import d.a.c.e.m.e;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static c f54302d;

    /* renamed from: a  reason: collision with root package name */
    public Wire f54303a = new Wire(new Class[0]);

    /* renamed from: b  reason: collision with root package name */
    public Map<String, d.a.n0.f0.i.a> f54304b = null;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f54305c = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: d.a.n0.f0.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1304a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Map f54307a;

            public C1304a(Map map) {
                this.f54307a = map;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                WriteHistroyDataReqIdl.Builder builder = new WriteHistroyDataReqIdl.Builder();
                builder.connect_point_list = new ArrayList();
                for (Map.Entry entry : this.f54307a.entrySet()) {
                    ConnectPointData c2 = d.a.n0.f0.i.a.c((d.a.n0.f0.i.a) entry.getValue());
                    if (c2 != null) {
                        builder.connect_point_list.add(c2);
                    }
                }
                c.this.g(builder.build(true).toByteArray());
                synchronized (c.class) {
                    c.this.f54304b = null;
                }
                return null;
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Map map;
            synchronized (c.class) {
                map = c.this.f54304b;
            }
            if (map == null) {
                return;
            }
            h0.b(new C1304a(map), null);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<WriteHistroyDataReqIdl> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public WriteHistroyDataReqIdl doInBackground() {
            byte[] f2 = c.this.f();
            if (f2 != null) {
                try {
                    return (WriteHistroyDataReqIdl) c.this.f54303a.parseFrom(f2, WriteHistroyDataReqIdl.class);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
    }

    /* renamed from: d.a.n0.f0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1305c implements n<WriteHistroyDataReqIdl> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f54310a;

        public C1305c(c cVar, n nVar) {
            this.f54310a = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            n nVar = this.f54310a;
            if (nVar != null) {
                nVar.onReturnDataInUI(writeHistroyDataReqIdl);
            }
        }
    }

    public static final c h() {
        if (f54302d == null) {
            synchronized (c.class) {
                if (f54302d == null) {
                    f54302d = new c();
                }
            }
        }
        return f54302d;
    }

    public final byte[] f() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                fileInputStream = BdBaseApplication.getInst().getContext().openFileInput("dnsproxydata");
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read >= 0) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                return byteArrayOutputStream.toByteArray();
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        BdLog.detailException(e);
                        d.a.n0.f0.d.c().a("read_dnsproxydata", e.getMessage());
                        return null;
                    } catch (IOException e3) {
                        e = e3;
                        BdLog.detailException(e);
                        d.a.n0.f0.d.c().a("read_dnsproxydata", e.getMessage());
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        BdLog.detailException(th);
                        d.a.n0.f0.d.c().a("read_dnsproxydata", th.getMessage());
                        return null;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    byteArrayOutputStream = null;
                } catch (IOException e5) {
                    e = e5;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } finally {
                d.a.c.e.m.a.c(fileInputStream);
                d.a.c.e.m.a.d(byteArrayOutputStream);
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (IOException e7) {
            e = e7;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    public final void g(byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = BdBaseApplication.getInst().getContext().openFileOutput("dnsproxydata", 0);
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                } catch (IOException e2) {
                    BdLog.detailException(e2);
                    d.a.n0.f0.d.c().a("save_dnsproxydata", e2.getMessage());
                }
            } catch (FileNotFoundException e3) {
                BdLog.detailException(e3);
                d.a.n0.f0.d.c().a("save_dnsproxydata", e3.getMessage());
            } catch (Throwable th) {
                BdLog.detailException(th);
                d.a.n0.f0.d.c().a("save_dnsproxydata", th.getMessage());
            }
            d.a.c.e.m.a.d(fileOutputStream);
        } catch (Throwable th2) {
            d.a.c.e.m.a.d(fileOutputStream);
            throw th2;
        }
    }

    public void i(n<WriteHistroyDataReqIdl> nVar) {
        h0.b(new b(), new C1305c(this, nVar));
    }

    public void j(Map<String, d.a.n0.f0.i.a> map) {
        if (TbadkCoreApplication.getInst().isMainProcess(false) && map != null) {
            synchronized (c.class) {
                this.f54304b = map;
            }
            if (e.a().hasMessages(0, this)) {
                return;
            }
            Message obtain = Message.obtain(e.a(), this.f54305c);
            obtain.what = 0;
            obtain.obj = this;
            e.a().sendMessageDelayed(obtain, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
        }
    }

    public void k() {
        e.a().removeMessages(0, this);
        e.a().post(this.f54305c);
    }
}
