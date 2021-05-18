package d.a.k0.e1.h;

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
    public static e f54284c;

    /* renamed from: a  reason: collision with root package name */
    public b f54285a;

    /* renamed from: b  reason: collision with root package name */
    public final DialogInterface.OnCancelListener f54286b = new a();

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
        public final d.a.k0.e1.f.i.b f54288a;

        /* renamed from: b  reason: collision with root package name */
        public final int f54289b;

        /* renamed from: c  reason: collision with root package name */
        public c f54290c = new a();

        /* loaded from: classes4.dex */
        public class a implements c {
            public a() {
            }

            @Override // d.a.k0.e1.h.e.c
            public void a(int i2, String str, int i3) {
                if (b.this.isCancelled()) {
                    b.this.h(i2, str, i3);
                    return;
                }
                d dVar = new d();
                dVar.f54299a = str;
                dVar.f54300b = i3;
                dVar.f54301c = i2;
                b.this.publishProgress(dVar);
            }

            @Override // d.a.k0.e1.h.e.c
            public void b(List<d> list) {
                b.this.i(list);
            }
        }

        /* renamed from: d.a.k0.e1.h.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1294b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f54293e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f54294f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f54295g;

            public RunnableC1294b(int i2, String str, int i3) {
                this.f54293e = i2;
                this.f54294f = str;
                this.f54295g = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f54288a != null) {
                    b.this.f54288a.onProgressUpdate(this.f54293e, this.f54294f, this.f54295g);
                    b.this.f54288a.onCanceled();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f54297e;

            public c(List list) {
                this.f54297e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f54297e == null || b.this.f54288a == null) {
                    return;
                }
                for (d dVar : this.f54297e) {
                    if (dVar != null) {
                        b.this.f54288a.onProgressUpdate(dVar.f54301c, dVar.f54299a, dVar.f54300b);
                    }
                }
                b.this.f54288a.onCanceled();
                this.f54297e.clear();
            }
        }

        public b(int i2, d.a.k0.e1.f.i.b bVar) {
            this.f54289b = i2;
            this.f54288a = bVar;
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
                    int i2 = this.f54289b;
                    if (i2 == 4) {
                        e.this.d(list, this.f54290c);
                    } else if (i2 == 2) {
                        e.this.f(list, this.f54290c);
                    }
                } else if (obj instanceof ImMessageCenterShowItemData) {
                    e.this.s(((ImMessageCenterShowItemData) obj).getFriendId(), this.f54289b, this.f54290c);
                }
                return 0;
            }
            return -2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public void onProgressUpdate(d... dVarArr) {
            d.a.k0.e1.f.i.b bVar;
            super.onProgressUpdate(dVarArr);
            if (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null || (bVar = this.f54288a) == null) {
                return;
            }
            d dVar = dVarArr[0];
            bVar.onProgressUpdate(dVar.f54301c, dVar.f54299a, dVar.f54300b);
        }

        public final void h(int i2, String str, int i3) {
            d.a.c.e.m.e.a().post(new RunnableC1294b(i2, str, i3));
        }

        public final void i(List<d> list) {
            d.a.c.e.m.e.a().post(new c(list));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            d.a.k0.e1.f.i.b bVar = this.f54288a;
            if (bVar != null) {
                bVar.onCanceled();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            d.a.k0.e1.f.i.b bVar = this.f54288a;
            if (bVar != null) {
                bVar.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            if (this.f54288a != null) {
                if (isCancelled()) {
                    this.f54288a.onCanceled();
                } else {
                    this.f54288a.onPostExecute();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2, String str, int i3);

        void b(List<d> list);
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f54299a;

        /* renamed from: b  reason: collision with root package name */
        public int f54300b;

        /* renamed from: c  reason: collision with root package name */
        public int f54301c;
    }

    public static e m() {
        if (f54284c == null) {
            synchronized (e.class) {
                if (f54284c == null) {
                    f54284c = new e();
                }
            }
        }
        return f54284c;
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, d.a.k0.e1.f.i.b bVar) {
        b bVar2 = new b(i2, bVar);
        this.f54285a = bVar2;
        bVar2.setParallel(TiebaIMConfig.getParallel());
        this.f54285a.setPriority(3);
        this.f54285a.execute(imMessageCenterShowItemData);
    }

    public void b(List<ImMessageCenterShowItemData> list, int i2, d.a.k0.e1.f.i.b bVar) {
        b bVar2 = new b(i2, bVar);
        this.f54285a = bVar2;
        bVar2.setParallel(TiebaIMConfig.getParallel());
        this.f54285a.setPriority(3);
        this.f54285a.execute(list);
    }

    public boolean c() {
        b bVar = this.f54285a;
        if (bVar != null && bVar.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
            this.f54285a.cancel(true);
        }
        this.f54285a = null;
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
            int i2 = 0;
            for (int i3 = size - 1; i3 >= 0; i3--) {
                if (o()) {
                    break;
                }
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) ListUtils.getItem(list, i3);
                if (imMessageCenterShowItemData != null && !TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                    String friendId = imMessageCenterShowItemData.getFriendId();
                    k(friendId, 4);
                    l.t().e(friendId);
                    i2++;
                    if (cVar != null) {
                        cVar.a((i2 * 100) / size, friendId, 4);
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
                int i2 = 0;
                for (String str : v) {
                    if (o()) {
                        break;
                    }
                    k(str, 4);
                    l.t().e(str);
                    i2++;
                    if (cVar != null) {
                        cVar.a((i2 * 100) / size, str, 4);
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
        int i2;
        int i3;
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
                int i4 = size2 / 100;
                if (size2 % 100 != 0) {
                    i4++;
                }
                int i5 = 0;
                while (i5 < i4) {
                    if (!o()) {
                        if (i5 == i4 - 1) {
                            i2 = 100 * i5;
                            i3 = size2;
                        } else {
                            i2 = 100 * i5;
                            i3 = i2 + 100;
                        }
                        i5++;
                        l(ListUtils.subList(arrayList, i2, i3), cVar, (i5 * 100) / i4);
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
        int i2;
        int i3;
        try {
            try {
                h.e().i();
                List<String> e2 = n.e();
                if (!ListUtils.isEmpty(e2)) {
                    int size = e2.size();
                    int i4 = size / 100;
                    if (size % 100 != 0) {
                        i4++;
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= i4) {
                            break;
                        } else if (o()) {
                            break;
                        } else {
                            if (i5 == i4 - 1) {
                                i2 = 100 * i5;
                                i3 = size;
                            } else {
                                i2 = 100 * i5;
                                i3 = i2 + 100;
                            }
                            i5++;
                            l(ListUtils.subList(e2, i2, i3), cVar, (i5 * 100) / i4);
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
                ImMessageCenterPojo i2 = d.a.k0.e1.k.b.o().i(str, 1);
                i2.setIs_hidden(1);
                i2.setUnread_count(0);
                j.f().k(i2, 2);
                d.a.k0.e1.h.c.h().d(str);
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

    public void k(String str, int i2) {
        j.f().c(str, i2);
    }

    public final void l(List<String> list, c cVar, int i2) {
        if (list == null || cVar == null) {
            return;
        }
        n.b(t(list));
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            m.t().d(str);
            if (o()) {
                d dVar = new d();
                dVar.f54299a = str;
                dVar.f54300b = 2;
                dVar.f54301c = i2;
                arrayList.add(dVar);
            } else {
                cVar.a(i2, str, 2);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return;
        }
        cVar.b(arrayList);
    }

    public void n(String str, int i2) {
        try {
            try {
                h.e().i();
                ImMessageCenterPojo i3 = d.a.k0.e1.k.b.o().i(str, i2);
                i3.setIs_hidden(1);
                i3.setUnread_count(0);
                j.f().k(i3, 2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            h.e().c();
        }
    }

    public boolean o() {
        b bVar = this.f54285a;
        if (bVar != null) {
            return bVar != null && bVar.isCancelled();
        }
        return true;
    }

    public d.a.j0.r.s.c p(Context context) {
        d.a.j0.r.s.c cVar = new d.a.j0.r.s.c(context);
        cVar.a(context.getString(R.string.delete_msg_loading));
        cVar.setCanceledOnTouchOutside(false);
        cVar.setCancelable(true);
        cVar.setOnCancelListener(this.f54286b);
        return cVar;
    }

    public void q(String str, int i2) {
        ImMessageCenterPojo i3 = d.a.k0.e1.k.b.o().i(str, i2);
        if (i3 == null) {
            return;
        }
        if (i2 == 2) {
            d.a.j0.s.d.b.g0().s(str);
        } else if (i2 == 4) {
            d.a.j0.s.d.b.g0().r(d.a.c.e.m.b.d(str, 0));
        } else if (i2 == -3) {
            d.a.j0.s.d.b.g0().f(2);
        } else if (i2 == -4) {
            d.a.j0.s.d.b.g0().f(1);
        } else {
            d.a.j0.s.d.b.g0().d(str);
        }
        i3.setIs_hidden(1);
        i3.setUnread_count(0);
        if (i2 == 2 || i2 == 4 || i2 == -7 || i2 == -8) {
            d.a.k0.e1.k.b.o().G(str, i2);
        } else if (i2 == 1) {
            d.a.k0.e1.k.b.o().B(str, i2, false);
        } else {
            d.a.k0.e1.k.b.o().B(str, i2, false);
        }
    }

    public void r(String str, int i2) {
        d.a.k0.e1.k.b.o().H(str, i2);
    }

    public void s(String str, int i2, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (1 == i2) {
            h(str);
        } else if (-7 == i2) {
            g(cVar);
        } else if (-8 == i2) {
            e(cVar);
        } else if (2 == i2) {
            j(str);
        } else if (4 == i2) {
            i(str);
        } else if (-3 == i2) {
            n(str, i2);
        } else if (-4 == i2) {
            n(str, i2);
        } else {
            n(str, i2);
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
