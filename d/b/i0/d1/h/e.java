package d.b.i0.d1.h;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f53778c;

    /* renamed from: a  reason: collision with root package name */
    public b f53779a;

    /* renamed from: b  reason: collision with root package name */
    public final DialogInterface.OnCancelListener f53780b = new a();

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.c();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, d, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final d.b.i0.d1.f.i.b f53782a;

        /* renamed from: b  reason: collision with root package name */
        public final int f53783b;

        /* renamed from: c  reason: collision with root package name */
        public c f53784c = new a();

        /* loaded from: classes4.dex */
        public class a implements c {
            public a() {
            }

            @Override // d.b.i0.d1.h.e.c
            public void a(List<d> list) {
                b.this.i(list);
            }

            @Override // d.b.i0.d1.h.e.c
            public void b(int i, String str, int i2) {
                if (b.this.isCancelled()) {
                    b.this.h(i, str, i2);
                    return;
                }
                d dVar = new d();
                dVar.f53793a = str;
                dVar.f53794b = i2;
                dVar.f53795c = i;
                b.this.publishProgress(dVar);
            }
        }

        /* renamed from: d.b.i0.d1.h.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1196b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f53787e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f53788f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f53789g;

            public RunnableC1196b(int i, String str, int i2) {
                this.f53787e = i;
                this.f53788f = str;
                this.f53789g = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f53782a != null) {
                    b.this.f53782a.onProgressUpdate(this.f53787e, this.f53788f, this.f53789g);
                    b.this.f53782a.onCanceled();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f53791e;

            public c(List list) {
                this.f53791e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f53791e == null || b.this.f53782a == null) {
                    return;
                }
                for (d dVar : this.f53791e) {
                    if (dVar != null) {
                        b.this.f53782a.onProgressUpdate(dVar.f53795c, dVar.f53793a, dVar.f53794b);
                    }
                }
                b.this.f53782a.onCanceled();
                this.f53791e.clear();
            }
        }

        public b(int i, d.b.i0.d1.f.i.b bVar) {
            this.f53783b = i;
            this.f53782a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Integer doInBackground(Object... objArr) {
            if (isCancelled()) {
                return -1;
            }
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                Object obj = objArr[0];
                if (obj instanceof ArrayList) {
                    List<ImMessageCenterShowItemData> list = (List) obj;
                    int i = this.f53783b;
                    if (i == 4) {
                        e.this.d(list, this.f53784c);
                    } else if (i == 2) {
                        e.this.f(list, this.f53784c);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.s(((ImMessageCenterShowItemData) obj).getFriendId(), this.f53783b, this.f53784c);
                }
                return 0;
            }
            return -2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public void onProgressUpdate(d... dVarArr) {
            d.b.i0.d1.f.i.b bVar;
            super.onProgressUpdate(dVarArr);
            if (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null || (bVar = this.f53782a) == null) {
                return;
            }
            d dVar = dVarArr[0];
            bVar.onProgressUpdate(dVar.f53795c, dVar.f53793a, dVar.f53794b);
        }

        public final void h(int i, String str, int i2) {
            d.b.b.e.m.e.a().post(new RunnableC1196b(i, str, i2));
        }

        public final void i(List<d> list) {
            d.b.b.e.m.e.a().post(new c(list));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            d.b.i0.d1.f.i.b bVar = this.f53782a;
            if (bVar != null) {
                bVar.onCanceled();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            d.b.i0.d1.f.i.b bVar = this.f53782a;
            if (bVar != null) {
                bVar.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            if (this.f53782a != null) {
                if (isCancelled()) {
                    this.f53782a.onCanceled();
                } else {
                    this.f53782a.onPostExecute();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<d> list);

        void b(int i, String str, int i2);
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f53793a;

        /* renamed from: b  reason: collision with root package name */
        public int f53794b;

        /* renamed from: c  reason: collision with root package name */
        public int f53795c;
    }

    public static e m() {
        if (f53778c == null) {
            synchronized (e.class) {
                if (f53778c == null) {
                    f53778c = new e();
                }
            }
        }
        return f53778c;
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, d.b.i0.d1.f.i.b bVar) {
        b bVar2 = new b(i, bVar);
        this.f53779a = bVar2;
        bVar2.setParallel(TiebaIMConfig.getParallel());
        this.f53779a.setPriority(3);
        this.f53779a.execute(imMessageCenterShowItemData);
    }

    public void b(List<ImMessageCenterShowItemData> list, int i, d.b.i0.d1.f.i.b bVar) {
        b bVar2 = new b(i, bVar);
        this.f53779a = bVar2;
        bVar2.setParallel(TiebaIMConfig.getParallel());
        this.f53779a.setPriority(3);
        this.f53779a.execute(list);
    }

    public boolean c() {
        b bVar = this.f53779a;
        if (bVar != null && bVar.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.f53779a.cancel(true);
        }
        this.f53779a = null;
        return true;
    }

    public void d(List<ImMessageCenterShowItemData> list, c cVar) {
        try {
            try {
                h.e().i();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            int size = list.size();
            int i = 0;
            for (int i2 = size - 1; i2 >= 0; i2--) {
                if (o()) {
                    break;
                }
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) ListUtils.getItem(list, i2);
                if (imMessageCenterShowItemData != null && !TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                    String friendId = imMessageCenterShowItemData.getFriendId();
                    k(friendId, 4);
                    l.t().e(friendId);
                    i++;
                    if (cVar != null) {
                        cVar.b((i * 100) / size, friendId, 4);
                    }
                }
            }
        } finally {
            h.e().c();
        }
    }

    public void e(c cVar) {
        List<String> v;
        try {
            try {
                h.e().i();
                l.t();
                v = l.v();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!ListUtils.isEmpty(v)) {
                int size = v.size();
                int i = 0;
                for (String str : v) {
                    if (o()) {
                        break;
                    }
                    k(str, 4);
                    l.t().e(str);
                    i++;
                    if (cVar != null) {
                        cVar.b((i * 100) / size, str, 4);
                    }
                }
                if (!o()) {
                    k(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                }
            }
        } finally {
            h.e().c();
        }
    }

    public void f(List<ImMessageCenterShowItemData> list, c cVar) {
        int i;
        int i2;
        try {
            try {
                h.e().i();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!ListUtils.isEmpty(list)) {
                ArrayList arrayList = new ArrayList(list.size());
                for (int size = list.size() - 1; size >= 0; size--) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) ListUtils.getItem(list, size);
                    if (imMessageCenterShowItemData != null && !TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        arrayList.add(imMessageCenterShowItemData.getFriendId());
                    }
                }
                int size2 = arrayList.size();
                int i3 = size2 / 100;
                if (size2 % 100 != 0) {
                    i3++;
                }
                int i4 = 0;
                while (i4 < i3) {
                    if (!o()) {
                        if (i4 == i3 - 1) {
                            i = 100 * i4;
                            i2 = size2;
                        } else {
                            i = 100 * i4;
                            i2 = i + 100;
                        }
                        i4++;
                        l(ListUtils.subList(arrayList, i, i2), cVar, (i4 * 100) / i3);
                    }
                }
            }
        } finally {
            h.e().c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (o() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
        k(com.baidu.tbadk.core.util.TbEnum.CustomGroupId.STRANGE_MERGE, -7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(c cVar) {
        int i;
        int i2;
        try {
            try {
                h.e().i();
                List<String> e2 = n.e();
                if (!ListUtils.isEmpty(e2)) {
                    int size = e2.size();
                    int i3 = size / 100;
                    if (size % 100 != 0) {
                        i3++;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= i3) {
                            break;
                        } else if (o()) {
                            break;
                        } else {
                            if (i4 == i3 - 1) {
                                i = 100 * i4;
                                i2 = size;
                            } else {
                                i = 100 * i4;
                                i2 = i + 100;
                            }
                            i4++;
                            l(ListUtils.subList(e2, i, i2), cVar, (i4 * 100) / i3);
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } finally {
            h.e().c();
        }
    }

    public void h(String str) {
        try {
            try {
                h.e().i();
                ImMessageCenterPojo i = d.b.i0.d1.k.b.o().i(str, 1);
                i.setIs_hidden(1);
                i.setUnread_count(0);
                j.f().k(i, 2);
                d.b.i0.d1.h.c.h().d(str);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        } finally {
            h.e().c();
        }
    }

    public void i(String str) {
        try {
            try {
                h.e().i();
                k(str, 4);
                l.t().e(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            h.e().c();
        }
    }

    public void j(String str) {
        try {
            try {
                h.e().i();
                k(str, 2);
                m.t().e(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            h.e().c();
        }
    }

    public void k(String str, int i) {
        j.f().c(str, i);
    }

    public final void l(List<String> list, c cVar, int i) {
        if (list == null || cVar == null) {
            return;
        }
        n.b(t(list));
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            m.t().d(str);
            if (o()) {
                d dVar = new d();
                dVar.f53793a = str;
                dVar.f53794b = 2;
                dVar.f53795c = i;
                arrayList.add(dVar);
            } else {
                cVar.b(i, str, 2);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return;
        }
        cVar.a(arrayList);
    }

    public void n(String str, int i) {
        try {
            try {
                h.e().i();
                ImMessageCenterPojo i2 = d.b.i0.d1.k.b.o().i(str, i);
                i2.setIs_hidden(1);
                i2.setUnread_count(0);
                j.f().k(i2, 2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            h.e().c();
        }
    }

    public boolean o() {
        b bVar = this.f53779a;
        if (bVar != null) {
            return bVar != null && bVar.isCancelled();
        }
        return true;
    }

    public d.b.h0.r.s.c p(Context context) {
        d.b.h0.r.s.c cVar = new d.b.h0.r.s.c(context);
        cVar.a(context.getString(R.string.delete_msg_loading));
        cVar.setCanceledOnTouchOutside(false);
        cVar.setCancelable(true);
        cVar.setOnCancelListener(this.f53780b);
        return cVar;
    }

    public void q(String str, int i) {
        ImMessageCenterPojo i2 = d.b.i0.d1.k.b.o().i(str, i);
        if (i2 == null) {
            return;
        }
        if (i == 2) {
            d.b.h0.s.d.b.g0().s(str);
        } else if (i == 4) {
            d.b.h0.s.d.b.g0().r(d.b.b.e.m.b.d(str, 0));
        } else if (i == -3) {
            d.b.h0.s.d.b.g0().f(2);
        } else if (i == -4) {
            d.b.h0.s.d.b.g0().f(1);
        } else {
            d.b.h0.s.d.b.g0().d(str);
        }
        i2.setIs_hidden(1);
        i2.setUnread_count(0);
        if (i == 2 || i == 4 || i == -7 || i == -8) {
            d.b.i0.d1.k.b.o().G(str, i);
        } else if (i == 1) {
            d.b.i0.d1.k.b.o().B(str, i, false);
        } else {
            d.b.i0.d1.k.b.o().B(str, i, false);
        }
    }

    public void r(String str, int i) {
        d.b.i0.d1.k.b.o().H(str, i);
    }

    public void s(String str, int i, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (1 == i) {
            h(str);
        } else if (-7 == i) {
            g(cVar);
        } else if (-8 == i) {
            e(cVar);
        } else if (2 == i) {
            j(str);
        } else if (4 == i) {
            i(str);
        } else if (-3 == i) {
            n(str, i);
        } else if (-4 == i) {
            n(str, i);
        } else {
            n(str, i);
        }
    }

    public final String t(List<String> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
