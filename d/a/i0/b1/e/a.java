package d.a.i0.b1.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tbadk.widget.dragsort.DragSortItemView;
import com.baidu.tbadk.widget.dragsort.DragSortItemViewCheckable;
import com.baidu.tieba.R$styleable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements d.a.i0.b1.e.c {
    public int C;
    public int D;
    public float E;
    public float F;
    public float G;
    public float H;
    public int K;
    public int L;
    public int M;
    public MotionEvent R;
    public c V;
    public g X;

    /* renamed from: a  reason: collision with root package name */
    public View f48118a;
    public m b0;
    public l c0;

    /* renamed from: d  reason: collision with root package name */
    public int f48121d;
    public h d0;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f48123f;
    public ListView g0;
    public d.a.i0.b1.e.d h0;

    /* renamed from: i  reason: collision with root package name */
    public int f48126i;
    public d.a.i0.b1.e.b i0;
    public int j;
    public int k;
    public int m;
    public int n;
    public int o;
    public d p;
    public i q;
    public n r;
    public int v;
    public int w;
    public f z;

    /* renamed from: b  reason: collision with root package name */
    public Point f48119b = new Point();

    /* renamed from: c  reason: collision with root package name */
    public Point f48120c = new Point();

    /* renamed from: e  reason: collision with root package name */
    public boolean f48122e = false;

    /* renamed from: g  reason: collision with root package name */
    public float f48124g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f48125h = 1.0f;
    public boolean l = false;
    public boolean s = true;
    public int t = 0;
    public int u = 1;
    public int x = 0;
    public View[] y = new View[1];
    public float A = 0.33333334f;
    public float B = 0.33333334f;
    public float I = 0.5f;
    public e J = new C1021a();
    public int N = 0;
    public boolean O = false;
    public boolean P = false;
    public j Q = null;
    public int S = 0;
    public float T = 0.25f;
    public float U = 0.0f;
    public boolean W = false;
    public boolean Y = false;
    public boolean Z = false;
    public k a0 = new k(this, 3);
    public float f0 = 0.0f;
    public boolean j0 = false;

    /* renamed from: d.a.i0.b1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1021a implements e {
        public C1021a() {
        }

        @Override // d.a.i0.b1.e.a.e
        public float a(float f2, long j) {
            return a.this.I * f2;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        public final void a() {
            if (a.this.t == 4) {
                a.this.R();
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public ListAdapter f48129e;

        /* renamed from: d.a.i0.b1.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1022a extends DataSetObserver {
            public C1022a(a aVar) {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                c.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                c.this.notifyDataSetInvalidated();
            }
        }

        public c(ListAdapter listAdapter) {
            this.f48129e = listAdapter;
            listAdapter.registerDataSetObserver(new C1022a(a.this));
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.f48129e.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f48129e.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.f48129e.getItem(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return this.f48129e.getItemId(i2);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            return this.f48129e.getItemViewType(i2);
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            DragSortItemView dragSortItemView;
            DragSortItemView dragSortItemView2;
            if (view != null) {
                dragSortItemView2 = (DragSortItemView) view;
                View childAt = dragSortItemView2.getChildAt(0);
                View view2 = this.f48129e.getView(i2, childAt, a.this.g0);
                if (view2 != childAt) {
                    if (childAt != null) {
                        dragSortItemView2.removeViewAt(0);
                    }
                    dragSortItemView2.addView(view2);
                }
            } else {
                View view3 = this.f48129e.getView(i2, null, a.this.g0);
                if (view3 instanceof Checkable) {
                    dragSortItemView = new DragSortItemViewCheckable(a.this.g0.getContext());
                } else {
                    dragSortItemView = new DragSortItemView(a.this.g0.getContext());
                }
                dragSortItemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                dragSortItemView.addView(view3);
                dragSortItemView2 = dragSortItemView;
            }
            a aVar = a.this;
            aVar.M(i2 + aVar.g0.getHeaderViewsCount(), dragSortItemView2, true);
            return dragSortItemView2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.f48129e.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.f48129e.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.f48129e.isEmpty();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            return this.f48129e.isEnabled(i2);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void drag(int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public interface e {
        float a(float f2, long j);
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public boolean f48132e;

        /* renamed from: f  reason: collision with root package name */
        public long f48133f;

        /* renamed from: g  reason: collision with root package name */
        public long f48134g;

        /* renamed from: h  reason: collision with root package name */
        public int f48135h;

        /* renamed from: i  reason: collision with root package name */
        public float f48136i;
        public long j;
        public int k;
        public float l;
        public boolean m = false;

        public f() {
        }

        public int a() {
            if (this.m) {
                return this.k;
            }
            return -1;
        }

        public boolean b() {
            return this.m;
        }

        public void c(int i2) {
            if (this.m) {
                return;
            }
            this.f48132e = false;
            this.m = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.j = uptimeMillis;
            this.f48133f = uptimeMillis;
            this.k = i2;
            a.this.g0.post(this);
        }

        public void d(boolean z) {
            if (z) {
                a.this.g0.removeCallbacks(this);
                this.m = false;
                return;
            }
            this.f48132e = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f48132e) {
                int firstVisiblePosition = a.this.g0.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.g0.getLastVisiblePosition();
                int count = a.this.g0.getCount();
                int paddingTop = a.this.g0.getPaddingTop();
                int height = (a.this.g0.getHeight() - paddingTop) - a.this.g0.getPaddingBottom();
                int min = Math.min(a.this.L, a.this.f48121d + a.this.w);
                int max = Math.max(a.this.L, a.this.f48121d - a.this.w);
                if (this.k == 0) {
                    View childAt = a.this.g0.getChildAt(0);
                    if (childAt == null) {
                        this.m = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.m = false;
                        return;
                    } else {
                        this.l = a.this.J.a((a.this.F - max) / a.this.G, this.f48133f);
                    }
                } else {
                    View childAt2 = a.this.g0.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.m = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.m = false;
                        return;
                    } else {
                        this.l = -a.this.J.a((min - a.this.E) / a.this.H, this.f48133f);
                    }
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f48134g = uptimeMillis;
                float f2 = (float) (uptimeMillis - this.f48133f);
                this.f48136i = f2;
                int round = Math.round(this.l * f2);
                this.f48135h = round;
                if (round >= 0) {
                    this.f48135h = Math.min(height, round);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.f48135h = Math.max(-height, round);
                }
                View childAt3 = a.this.g0.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.f48135h;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.Y = true;
                a.this.g0.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.a();
                a.this.g0.invalidate();
                a.this.Y = false;
                a.this.W(lastVisiblePosition, childAt3, false);
                this.f48133f = this.f48134g;
                a.this.g0.post(this);
                return;
            }
            this.m = false;
        }
    }

    /* loaded from: classes3.dex */
    public class g {

        /* renamed from: b  reason: collision with root package name */
        public File f48138b;

        /* renamed from: a  reason: collision with root package name */
        public StringBuilder f48137a = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        public int f48139c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f48140d = 0;

        /* renamed from: e  reason: collision with root package name */
        public boolean f48141e = false;

        public g() {
            File file = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
            this.f48138b = file;
            if (file.exists()) {
                return;
            }
            try {
                this.f48138b.createNewFile();
                Log.d("mobeta", "file created");
            } catch (IOException e2) {
                Log.w("mobeta", "Could not create dslv_state.txt");
                Log.d("mobeta", e2.getMessage());
            }
        }

        public void a() {
            if (this.f48141e) {
                this.f48137a.append("<DSLVState>\n");
                int childCount = a.this.g0.getChildCount();
                int firstVisiblePosition = a.this.g0.getFirstVisiblePosition();
                this.f48137a.append("    <Positions>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    StringBuilder sb = this.f48137a;
                    sb.append(firstVisiblePosition + i2);
                    sb.append(",");
                }
                this.f48137a.append("</Positions>\n");
                this.f48137a.append("    <Tops>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    StringBuilder sb2 = this.f48137a;
                    sb2.append(a.this.g0.getChildAt(i3).getTop());
                    sb2.append(",");
                }
                this.f48137a.append("</Tops>\n");
                this.f48137a.append("    <Bottoms>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    StringBuilder sb3 = this.f48137a;
                    sb3.append(a.this.g0.getChildAt(i4).getBottom());
                    sb3.append(",");
                }
                this.f48137a.append("</Bottoms>\n");
                StringBuilder sb4 = this.f48137a;
                sb4.append("    <FirstExpPos>");
                sb4.append(a.this.j);
                sb4.append("</FirstExpPos>\n");
                StringBuilder sb5 = this.f48137a;
                sb5.append("    <FirstExpBlankHeight>");
                a aVar = a.this;
                int e0 = aVar.e0(aVar.j);
                a aVar2 = a.this;
                sb5.append(e0 - aVar2.c0(aVar2.j));
                sb5.append("</FirstExpBlankHeight>\n");
                StringBuilder sb6 = this.f48137a;
                sb6.append("    <SecondExpPos>");
                sb6.append(a.this.k);
                sb6.append("</SecondExpPos>\n");
                StringBuilder sb7 = this.f48137a;
                sb7.append("    <SecondExpBlankHeight>");
                a aVar3 = a.this;
                int e02 = aVar3.e0(aVar3.k);
                a aVar4 = a.this;
                sb7.append(e02 - aVar4.c0(aVar4.k));
                sb7.append("</SecondExpBlankHeight>\n");
                StringBuilder sb8 = this.f48137a;
                sb8.append("    <SrcPos>");
                sb8.append(a.this.m);
                sb8.append("</SrcPos>\n");
                StringBuilder sb9 = this.f48137a;
                sb9.append("    <SrcHeight>");
                sb9.append(a.this.v + a.this.g0.getDividerHeight());
                sb9.append("</SrcHeight>\n");
                StringBuilder sb10 = this.f48137a;
                sb10.append("    <ViewHeight>");
                sb10.append(a.this.g0.getHeight());
                sb10.append("</ViewHeight>\n");
                StringBuilder sb11 = this.f48137a;
                sb11.append("    <LastY>");
                sb11.append(a.this.M);
                sb11.append("</LastY>\n");
                StringBuilder sb12 = this.f48137a;
                sb12.append("    <FloatY>");
                sb12.append(a.this.f48121d);
                sb12.append("</FloatY>\n");
                this.f48137a.append("    <ShuffleEdges>");
                for (int i5 = 0; i5 < childCount; i5++) {
                    StringBuilder sb13 = this.f48137a;
                    a aVar5 = a.this;
                    sb13.append(aVar5.f0(firstVisiblePosition + i5, aVar5.g0.getChildAt(i5).getTop()));
                    sb13.append(",");
                }
                this.f48137a.append("</ShuffleEdges>\n");
                this.f48137a.append("</DSLVState>\n");
                int i6 = this.f48139c + 1;
                this.f48139c = i6;
                if (i6 > 1000) {
                    b();
                    this.f48139c = 0;
                }
            }
        }

        public void b() {
            if (this.f48141e) {
                try {
                    FileWriter fileWriter = new FileWriter(this.f48138b, this.f48140d != 0);
                    fileWriter.write(this.f48137a.toString());
                    this.f48137a.delete(0, this.f48137a.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.f48140d++;
                } catch (IOException unused) {
                }
            }
        }

        public void c() {
            this.f48137a.append("<DSLVStates>\n");
            this.f48140d = 0;
            this.f48141e = true;
        }

        public void d() {
            if (this.f48141e) {
                this.f48137a.append("</DSLVStates>\n");
                b();
                this.f48141e = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends o {
        public int n;
        public int o;
        public float p;
        public float q;

        public h(float f2, int i2) {
            super(f2, i2);
        }

        @Override // d.a.i0.b1.e.a.o
        public void a() {
            this.n = a.this.f48126i;
            this.o = a.this.m;
            a.this.t = 2;
            this.p = a.this.f48119b.y - f();
            this.q = a.this.f48119b.x - a.this.g0.getPaddingLeft();
        }

        @Override // d.a.i0.b1.e.a.o
        public void b() {
            a.this.b0();
        }

        @Override // d.a.i0.b1.e.a.o
        public void c(float f2, float f3) {
            int f4 = f();
            float paddingLeft = a.this.f48119b.x - a.this.g0.getPaddingLeft();
            float f5 = 1.0f - f3;
            if (f5 < Math.abs((a.this.f48119b.y - f4) / this.p) || f5 < Math.abs(paddingLeft / this.q)) {
                a.this.f48119b.y = f4 + ((int) (this.p * f5));
                a.this.f48119b.x = a.this.g0.getPaddingLeft() + ((int) (this.q * f5));
                a.this.X(true);
            }
        }

        public final int f() {
            int bottom;
            int firstVisiblePosition = a.this.g0.getFirstVisiblePosition();
            int dividerHeight = (a.this.u + a.this.g0.getDividerHeight()) / 2;
            View childAt = a.this.g0.getChildAt(this.n - firstVisiblePosition);
            if (childAt != null) {
                int i2 = this.n;
                int i3 = this.o;
                if (i2 == i3) {
                    return childAt.getTop();
                }
                if (i2 < i3) {
                    bottom = childAt.getTop();
                } else {
                    bottom = childAt.getBottom() + dividerHeight;
                    dividerHeight = a.this.v;
                }
                return bottom - dividerHeight;
            }
            cancel();
            return -1;
        }
    }

    /* loaded from: classes3.dex */
    public interface i {
        void drop(int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(View view);

        View b(int i2);

        void c(View view, Point point, Point point2);
    }

    /* loaded from: classes3.dex */
    public class k {

        /* renamed from: a  reason: collision with root package name */
        public SparseIntArray f48143a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Integer> f48144b;

        /* renamed from: c  reason: collision with root package name */
        public int f48145c;

        public k(a aVar, int i2) {
            this.f48143a = new SparseIntArray(i2);
            this.f48144b = new ArrayList<>(i2);
            this.f48145c = i2;
        }

        public void a(int i2, int i3) {
            int i4 = this.f48143a.get(i2, -1);
            if (i4 != i3) {
                if (i4 == -1) {
                    if (this.f48143a.size() == this.f48145c) {
                        this.f48143a.delete(this.f48144b.remove(0).intValue());
                    }
                } else {
                    this.f48144b.remove(Integer.valueOf(i2));
                }
                this.f48143a.put(i2, i3);
                this.f48144b.add(Integer.valueOf(i2));
            }
        }

        public void b() {
            this.f48143a.clear();
            this.f48144b.clear();
        }

        public int c(int i2) {
            return this.f48143a.get(i2, -1);
        }
    }

    /* loaded from: classes3.dex */
    public class l extends o {
    }

    /* loaded from: classes3.dex */
    public class m extends o {
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;

        public m(float f2, int i2) {
            super(f2, i2);
            this.q = -1;
            this.r = -1;
        }

        @Override // d.a.i0.b1.e.a.o
        public void a() {
            this.q = -1;
            this.r = -1;
            this.s = a.this.j;
            this.t = a.this.k;
            int unused = a.this.m;
            a.this.t = 1;
            this.n = a.this.f48119b.x;
            if (a.this.e0) {
                float width = a.this.g0.getWidth() * 2.0f;
                if (a.this.f0 == 0.0f) {
                    a.this.f0 = (this.n >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f2 = width * 2.0f;
                if (a.this.f0 < 0.0f) {
                    float f3 = -f2;
                    if (a.this.f0 > f3) {
                        a.this.f0 = f3;
                        return;
                    }
                }
                if (a.this.f0 <= 0.0f || a.this.f0 >= f2) {
                    return;
                }
                a.this.f0 = f2;
                return;
            }
            a.this.U();
        }

        @Override // d.a.i0.b1.e.a.o
        public void b() {
            a.this.Y();
        }

        @Override // d.a.i0.b1.e.a.o
        public void c(float f2, float f3) {
            View childAt;
            float f4 = 1.0f - f3;
            int firstVisiblePosition = a.this.g0.getFirstVisiblePosition();
            View childAt2 = a.this.g0.getChildAt(this.s - firstVisiblePosition);
            if (a.this.e0) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f48146e)) / 1000.0f;
                if (uptimeMillis == 0.0f) {
                    return;
                }
                float f5 = a.this.f0 * uptimeMillis;
                int width = a.this.g0.getWidth();
                a aVar = a.this;
                float f6 = (a.this.f0 > 0.0f ? 1 : -1) * uptimeMillis;
                float f7 = width;
                aVar.f0 = aVar.f0 + (f6 * f7);
                this.n += f5;
                Point point = a.this.f48119b;
                float f8 = this.n;
                point.x = (int) f8;
                if (f8 < f7 && f8 > (-width)) {
                    this.f48146e = SystemClock.uptimeMillis();
                    a.this.X(true);
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.q == -1) {
                    this.q = a.this.d0(this.s, childAt2, false);
                    this.o = childAt2.getHeight() - this.q;
                }
                int max = Math.max((int) (this.o * f4), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = this.q + max;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.t == this.s || (childAt = a.this.g0.getChildAt(this.t - firstVisiblePosition)) == null) {
                return;
            }
            if (this.r == -1) {
                this.r = a.this.d0(this.t, childAt, false);
                this.p = childAt.getHeight() - this.r;
            }
            int max2 = Math.max((int) (f4 * this.p), 1);
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            layoutParams2.height = this.r + max2;
            childAt.setLayoutParams(layoutParams2);
        }
    }

    /* loaded from: classes3.dex */
    public interface n {
        void remove(int i2);
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f48146e;

        /* renamed from: f  reason: collision with root package name */
        public float f48147f;

        /* renamed from: g  reason: collision with root package name */
        public float f48148g;

        /* renamed from: h  reason: collision with root package name */
        public float f48149h;

        /* renamed from: i  reason: collision with root package name */
        public float f48150i;
        public float j;
        public float k;
        public boolean l;

        public o(float f2, int i2) {
            this.f48148g = f2;
            this.f48147f = i2;
            float f3 = 1.0f / ((f2 * 2.0f) * (1.0f - f2));
            this.k = f3;
            this.f48149h = f3;
            this.f48150i = f2 / ((f2 - 1.0f) * 2.0f);
            this.j = 1.0f / (1.0f - f2);
        }

        public abstract void a();

        public abstract void b();

        public abstract void c(float f2, float f3);

        public void cancel() {
            this.l = true;
        }

        public void d() {
            this.f48146e = SystemClock.uptimeMillis();
            this.l = false;
            a();
            a.this.g0.post(this);
        }

        public float e(float f2) {
            float f3 = this.f48148g;
            if (f2 < f3) {
                return this.f48149h * f2 * f2;
            }
            if (f2 < 1.0f - f3) {
                return this.f48150i + (this.j * f2);
            }
            float f4 = f2 - 1.0f;
            return 1.0f - ((this.k * f4) * f4);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.l) {
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f48146e)) / this.f48147f;
            if (uptimeMillis >= 1.0f) {
                c(1.0f, 1.0f);
                b();
                return;
            }
            c(uptimeMillis, e(uptimeMillis));
            a.this.g0.post(this);
        }
    }

    public a(ListView listView, d.a.i0.b1.e.d dVar) {
        this.h0 = dVar;
        this.g0 = listView;
    }

    public boolean A0(boolean z, float f2) {
        this.e0 = true;
        return z0(z, f2);
    }

    public final void B0() {
        int i2;
        int i3;
        if (this.Q != null) {
            this.f48120c.set(this.K, this.L);
            this.Q.c(this.f48118a, this.f48119b, this.f48120c);
        }
        Point point = this.f48119b;
        int i4 = point.x;
        int i5 = point.y;
        int paddingLeft = this.g0.getPaddingLeft();
        if ((this.N & 1) == 0 && i4 > paddingLeft) {
            this.f48119b.x = paddingLeft;
        } else if ((this.N & 2) == 0 && i4 < paddingLeft) {
            this.f48119b.x = paddingLeft;
        }
        int headerViewsCount = this.g0.getHeaderViewsCount();
        int footerViewsCount = this.g0.getFooterViewsCount();
        int firstVisiblePosition = this.g0.getFirstVisiblePosition();
        int lastVisiblePosition = this.g0.getLastVisiblePosition();
        int paddingTop = this.g0.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.g0.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.N & 8) == 0 && firstVisiblePosition <= (i3 = this.m)) {
            paddingTop = Math.max(this.g0.getChildAt(i3 - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.g0.getHeight() - this.g0.getPaddingBottom();
        if (lastVisiblePosition >= (this.g0.getCount() - footerViewsCount) - 1) {
            ListView listView = this.g0;
            height = listView.getChildAt(((listView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.N & 4) == 0 && lastVisiblePosition >= (i2 = this.m)) {
            height = Math.min(this.g0.getChildAt(i2 - firstVisiblePosition).getBottom(), height);
        }
        if (i5 < paddingTop) {
            this.f48119b.y = paddingTop;
        } else {
            int i6 = this.v;
            if (i5 + i6 > height) {
                this.f48119b.y = height - i6;
            }
        }
        this.f48121d = this.f48119b.y + this.w;
    }

    public final boolean C0() {
        int i2;
        int i3;
        int firstVisiblePosition = this.g0.getFirstVisiblePosition();
        int i4 = this.j;
        View childAt = this.g0.getChildAt(i4 - firstVisiblePosition);
        if (childAt == null) {
            i4 = (this.g0.getChildCount() / 2) + firstVisiblePosition;
            childAt = this.g0.getChildAt(i4 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int f0 = f0(i4, top);
        int dividerHeight = this.g0.getDividerHeight();
        if (this.f48121d < f0) {
            while (i4 >= 0) {
                i4--;
                int e0 = e0(i4);
                if (i4 == 0) {
                    i2 = (top - dividerHeight) - e0;
                    int i5 = f0;
                    f0 = i2;
                    i3 = i5;
                    break;
                }
                top -= e0 + dividerHeight;
                int f02 = f0(i4, top);
                if (this.f48121d >= f02) {
                    i3 = f0;
                    f0 = f02;
                    break;
                }
                f0 = f02;
            }
            i3 = f0;
        } else {
            int count = this.g0.getCount();
            while (i4 < count) {
                if (i4 == count - 1) {
                    i2 = top + dividerHeight + height;
                    int i52 = f0;
                    f0 = i2;
                    i3 = i52;
                    break;
                }
                top += height + dividerHeight;
                int i6 = i4 + 1;
                int e02 = e0(i6);
                int f03 = f0(i6, top);
                if (this.f48121d < f03) {
                    i3 = f0;
                    f0 = f03;
                    break;
                }
                i4 = i6;
                height = e02;
                f0 = f03;
            }
            i3 = f0;
        }
        int headerViewsCount = this.g0.getHeaderViewsCount();
        int footerViewsCount = this.g0.getFooterViewsCount();
        boolean z = false;
        int i7 = this.j;
        int i8 = this.k;
        float f2 = this.U;
        if (this.l) {
            int abs = Math.abs(f0 - i3);
            if (this.f48121d < f0) {
                int i9 = f0;
                f0 = i3;
                i3 = i9;
            }
            int i10 = (int) (this.T * 0.5f * abs);
            float f3 = i10;
            int i11 = f0 + i10;
            int i12 = i3 - i10;
            int i13 = this.f48121d;
            if (i13 < i11) {
                this.j = i4 - 1;
                this.k = i4;
                this.U = ((i11 - i13) * 0.5f) / f3;
            } else if (i13 < i12) {
                this.j = i4;
                this.k = i4;
            } else {
                this.j = i4;
                this.k = i4 + 1;
                this.U = (((i3 - i13) / f3) + 1.0f) * 0.5f;
            }
        } else {
            this.j = i4;
            this.k = i4;
        }
        if (this.j < headerViewsCount) {
            this.j = headerViewsCount;
            this.k = headerViewsCount;
            i4 = headerViewsCount;
        } else if (this.k >= this.g0.getCount() - footerViewsCount) {
            i4 = (this.g0.getCount() - footerViewsCount) - 1;
            this.j = i4;
            this.k = i4;
        }
        z = (this.j == i7 && this.k == i8 && this.U == f2) ? true : true;
        int i14 = this.f48126i;
        if (i4 != i14) {
            d dVar = this.p;
            if (dVar != null) {
                dVar.drag(i14 - headerViewsCount, i4 - headerViewsCount);
            }
            this.f48126i = i4;
            return true;
        }
        return z;
    }

    public final void D0() {
        int height;
        int paddingTop = this.g0.getPaddingTop();
        float height2 = (this.g0.getHeight() - paddingTop) - this.g0.getPaddingBottom();
        float f2 = paddingTop;
        float f3 = (this.A * height2) + f2;
        this.F = f3;
        float f4 = ((1.0f - this.B) * height2) + f2;
        this.E = f4;
        this.C = (int) f3;
        this.D = (int) f4;
        this.G = f3 - f2;
        this.H = (paddingTop + height) - f4;
    }

    public final void L() {
        int firstVisiblePosition = this.g0.getFirstVisiblePosition();
        int lastVisiblePosition = this.g0.getLastVisiblePosition();
        int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((this.g0.getCount() - 1) - this.g0.getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, this.g0.getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
            View childAt = this.g0.getChildAt(max);
            if (childAt != null) {
                M(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    public final void M(int i2, View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int Q = (i2 == this.m || i2 == this.j || i2 == this.k) ? Q(i2, view, z) : -2;
        if (Q != layoutParams.height) {
            layoutParams.height = Q;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.j || i2 == this.k) {
            int i3 = this.m;
            if (i2 < i3) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > i3) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i4 = 0;
        if (i2 == this.m && this.f48118a != null) {
            i4 = 4;
        }
        if (i4 != visibility) {
            view.setVisibility(i4);
        }
    }

    public final void N() {
        int firstVisiblePosition = this.g0.getFirstVisiblePosition();
        if (this.m < firstVisiblePosition) {
            View childAt = this.g0.getChildAt(0);
            int top = childAt != null ? childAt.getTop() : 0;
            ListView listView = this.g0;
            listView.setSelectionFromTop(firstVisiblePosition - 1, top - listView.getPaddingTop());
        }
    }

    public final int O(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int c0 = c0(i2);
        int height = view.getHeight();
        int P = P(i2, c0);
        if (i2 != this.m) {
            i5 = height - c0;
            i6 = P - c0;
        } else {
            i5 = height;
            i6 = P;
        }
        int i7 = this.v;
        int i8 = this.m;
        if (i8 != this.j && i8 != this.k) {
            i7 -= this.u;
        }
        if (i2 <= i3) {
            if (i2 > this.j) {
                return 0 + (i7 - i6);
            }
            return 0;
        } else if (i2 == i4) {
            if (i2 <= this.j) {
                i5 -= i7;
            } else if (i2 == this.k) {
                return 0 + (height - P);
            }
            return 0 + i5;
        } else if (i2 <= this.j) {
            return 0 - i7;
        } else {
            if (i2 == this.k) {
                return 0 - i6;
            }
            return 0;
        }
    }

    public final int P(int i2, int i3) {
        this.g0.getDividerHeight();
        boolean z = this.l && this.j != this.k;
        int i4 = this.v;
        int i5 = this.u;
        int i6 = i4 - i5;
        int i7 = (int) (this.U * i6);
        int i8 = this.m;
        return i2 == i8 ? i8 == this.j ? z ? i7 + i5 : i4 : i8 == this.k ? i4 - i7 : i5 : i2 == this.j ? z ? i3 + i7 : i3 + i6 : i2 == this.k ? (i3 + i6) - i7 : i3;
    }

    public final int Q(int i2, View view, boolean z) {
        return P(i2, d0(i2, view, z));
    }

    public void R() {
        if (this.t == 4) {
            this.z.d(true);
            U();
            S();
            L();
            if (this.P) {
                this.t = 3;
            } else {
                this.t = 0;
            }
        }
    }

    public final void S() {
        this.m = -1;
        this.j = -1;
        this.k = -1;
        this.f48126i = -1;
    }

    public final void T(int i2, int i3) {
        Point point = this.f48119b;
        point.x = i2 - this.n;
        point.y = i3 - this.o;
        X(true);
        int min = Math.min(i3, this.f48121d + this.w);
        int max = Math.max(i3, this.f48121d - this.w);
        int a2 = this.z.a();
        if (min > this.M && min > this.D && a2 != 1) {
            if (a2 != -1) {
                this.z.d(true);
            }
            this.z.c(1);
        } else if (max < this.M && max < this.C && a2 != 0) {
            if (a2 != -1) {
                this.z.d(true);
            }
            this.z.c(0);
        } else if (max < this.C || min > this.D || !this.z.b()) {
        } else {
            this.z.d(true);
        }
    }

    public final void U() {
        View view = this.f48118a;
        if (view != null) {
            view.setVisibility(8);
            j jVar = this.Q;
            if (jVar != null) {
                jVar.a(this.f48118a);
            }
            this.f48118a = null;
            this.g0.invalidate();
        }
    }

    public final void V() {
        this.S = 0;
        this.P = false;
        if (this.t == 3) {
            this.t = 0;
        }
        this.f48125h = this.f48124g;
        this.j0 = false;
        this.a0.b();
    }

    public final void W(int i2, View view, boolean z) {
        this.Y = true;
        B0();
        int i3 = this.j;
        int i4 = this.k;
        boolean C0 = C0();
        if (C0) {
            L();
            this.g0.setSelectionFromTop(i2, (view.getTop() + O(i2, view, i3, i4)) - this.g0.getPaddingTop());
            a();
        }
        if (C0 || z) {
            this.g0.invalidate();
        }
        this.Y = false;
    }

    public final void X(boolean z) {
        int firstVisiblePosition = this.g0.getFirstVisiblePosition() + (this.g0.getChildCount() / 2);
        ListView listView = this.g0;
        View childAt = listView.getChildAt(listView.getChildCount() / 2);
        if (childAt == null) {
            return;
        }
        W(firstVisiblePosition, childAt, z);
    }

    public final void Y() {
        Z(this.m - this.g0.getHeaderViewsCount());
    }

    public final void Z(int i2) {
        this.t = 1;
        n nVar = this.r;
        if (nVar != null) {
            nVar.remove(i2);
        }
        U();
        N();
        S();
        if (this.P) {
            this.t = 3;
        } else {
            this.t = 0;
        }
    }

    @Override // d.a.i0.b1.e.c
    public void a() {
        this.h0.a();
        View view = this.f48118a;
        if (view != null) {
            if (view.isLayoutRequested() && !this.f48122e) {
                i0();
            }
            View view2 = this.f48118a;
            view2.layout(0, 0, view2.getMeasuredWidth(), this.f48118a.getMeasuredHeight());
            this.f48122e = false;
        }
    }

    public final void a0(int i2, Canvas canvas) {
        int i3;
        int i4;
        Drawable divider = this.g0.getDivider();
        int dividerHeight = this.g0.getDividerHeight();
        if (divider == null || dividerHeight == 0) {
            return;
        }
        ListView listView = this.g0;
        ViewGroup viewGroup = (ViewGroup) listView.getChildAt(i2 - listView.getFirstVisiblePosition());
        if (viewGroup != null) {
            int paddingLeft = this.g0.getPaddingLeft();
            int width = this.g0.getWidth() - this.g0.getPaddingRight();
            int height = viewGroup.getChildAt(0).getHeight();
            if (i2 > this.m) {
                i4 = viewGroup.getTop() + height;
                i3 = dividerHeight + i4;
            } else {
                int bottom = viewGroup.getBottom() - height;
                int i5 = bottom - dividerHeight;
                i3 = bottom;
                i4 = i5;
            }
            canvas.save();
            canvas.clipRect(paddingLeft, i4, width, i3);
            divider.setBounds(paddingLeft, i4, width, i3);
            divider.draw(canvas);
            canvas.restore();
        }
    }

    @Override // d.a.i0.b1.e.c
    public void b(Canvas canvas) {
        float f2;
        this.h0.b(canvas);
        if (this.t != 0) {
            int i2 = this.j;
            if (i2 != this.m) {
                a0(i2, canvas);
            }
            int i3 = this.k;
            if (i3 != this.j && i3 != this.m) {
                a0(i3, canvas);
            }
        }
        View view = this.f48118a;
        if (view != null) {
            int width = view.getWidth();
            int height = this.f48118a.getHeight();
            int i4 = this.f48119b.x;
            int width2 = this.g0.getWidth();
            if (i4 < 0) {
                i4 = -i4;
            }
            if (i4 < width2) {
                float f3 = (width2 - i4) / width2;
                f2 = f3 * f3;
            } else {
                f2 = 0.0f;
            }
            canvas.save();
            Point point = this.f48119b;
            canvas.translate(point.x, point.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, (int) (this.f48125h * 255.0f * f2), 31);
            this.f48118a.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    public final void b0() {
        int i2;
        this.t = 2;
        if (this.q != null && (i2 = this.f48126i) >= 0 && i2 < this.g0.getCount()) {
            int headerViewsCount = this.g0.getHeaderViewsCount();
            this.q.drop(this.m - headerViewsCount, this.f48126i - headerViewsCount);
        }
        U();
        N();
        S();
        L();
        if (this.P) {
            this.t = 3;
        } else {
            this.t = 0;
        }
    }

    @Override // d.a.i0.b1.e.c
    public void c(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3;
        int i4 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DragSort, 0, 0);
            this.u = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R$styleable.DragSort_collapsed_height, 1));
            boolean z = obtainStyledAttributes.getBoolean(R$styleable.DragSort_track_drag_sort, false);
            this.W = z;
            if (z) {
                this.X = new g();
            }
            float f2 = obtainStyledAttributes.getFloat(R$styleable.DragSort_float_alpha, this.f48124g);
            this.f48124g = f2;
            this.f48125h = f2;
            this.s = obtainStyledAttributes.getBoolean(R$styleable.DragSort_drag_enabled, this.s);
            float max = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R$styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.T = max;
            this.l = max > 0.0f;
            q0(obtainStyledAttributes.getFloat(R$styleable.DragSort_drag_scroll_start, this.A));
            this.I = obtainStyledAttributes.getFloat(R$styleable.DragSort_max_drag_scroll_speed, this.I);
            int i5 = obtainStyledAttributes.getInt(R$styleable.DragSort_remove_animation_duration, 150);
            i2 = obtainStyledAttributes.getInt(R$styleable.DragSort_drop_animation_duration, 150);
            if (obtainStyledAttributes.getBoolean(R$styleable.DragSort_use_default_controller, true)) {
                boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.DragSort_remove_enabled, false);
                int i6 = obtainStyledAttributes.getInt(R$styleable.DragSort_tb_drag_remove_mode, 1);
                boolean z3 = obtainStyledAttributes.getBoolean(R$styleable.DragSort_sort_enabled, true);
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.DragSort_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.DragSort_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.DragSort_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(R$styleable.DragSort_float_background_color, -16777216);
                i3 = i5;
                d.a.i0.b1.e.b bVar = new d.a.i0.b1.e.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.r(z2);
                bVar.t(z3);
                bVar.d(color);
                this.Q = bVar;
                s0(bVar);
            } else {
                i3 = i5;
            }
            obtainStyledAttributes.recycle();
            i4 = i3;
        } else {
            i2 = 150;
        }
        this.z = new f();
        if (i4 > 0) {
            this.b0 = new m(0.5f, i4);
        }
        if (i2 > 0) {
            this.d0 = new h(0.5f, i2);
        }
        this.R = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.f48123f = new b();
    }

    public final int c0(int i2) {
        View view;
        if (i2 == this.m) {
            return 0;
        }
        ListView listView = this.g0;
        View childAt = listView.getChildAt(i2 - listView.getFirstVisiblePosition());
        if (childAt != null) {
            return d0(i2, childAt, false);
        }
        int c2 = this.a0.c(i2);
        if (c2 != -1) {
            return c2;
        }
        ListAdapter adapter = this.g0.getAdapter();
        int itemViewType = adapter.getItemViewType(i2);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.y.length) {
            this.y = new View[viewTypeCount];
        }
        if (itemViewType >= 0) {
            View[] viewArr = this.y;
            if (viewArr[itemViewType] == null) {
                view = adapter.getView(i2, null, this.g0);
                this.y[itemViewType] = view;
            } else {
                view = adapter.getView(i2, viewArr[itemViewType], this.g0);
            }
        } else {
            view = adapter.getView(i2, null, this.g0);
        }
        int d0 = d0(i2, view, true);
        this.a0.a(i2, d0);
        return d0;
    }

    public final int d0(int i2, View view, boolean z) {
        int i3;
        if (i2 == this.m) {
            return 0;
        }
        if (i2 >= this.g0.getHeaderViewsCount() && i2 < this.g0.getCount() - this.g0.getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || (i3 = layoutParams.height) <= 0) {
            int height = view.getHeight();
            if (height == 0 || z) {
                j0(view);
                return view.getMeasuredHeight();
            }
            return height;
        }
        return i3;
    }

    public final int e0(int i2) {
        ListView listView = this.g0;
        View childAt = listView.getChildAt(i2 - listView.getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return P(i2, c0(i2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        if (r8 <= r7.m) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int f0(int i2, int i3) {
        int headerViewsCount = this.g0.getHeaderViewsCount();
        int footerViewsCount = this.g0.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.g0.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.g0.getDividerHeight();
        int i4 = this.v - this.u;
        int c0 = c0(i2);
        int e0 = e0(i2);
        int i5 = this.k;
        int i6 = this.m;
        if (i5 <= i6) {
            if (i2 != i5 || this.j == i5) {
                if (i2 > this.k) {
                }
            } else if (i2 == i6) {
                i3 += e0;
                i4 = this.v;
            } else {
                i3 += e0 - c0;
            }
            i3 -= i4;
        } else if (i2 <= i6 || i2 > this.j) {
            int i7 = this.k;
            if (i2 == i7 && this.j != i7) {
                i3 += e0 - c0;
            }
        } else {
            i3 += i4;
        }
        if (i2 <= this.m) {
            return i3 + (((this.v - dividerHeight) - c0(i2 - 1)) / 2);
        }
        return i3 + (((c0 - dividerHeight) - this.v) / 2);
    }

    public boolean g0() {
        return this.s;
    }

    public boolean h0() {
        return this.j0;
    }

    public final void i0() {
        View view = this.f48118a;
        if (view != null) {
            j0(view);
            int measuredHeight = this.f48118a.getMeasuredHeight();
            this.v = measuredHeight;
            this.w = measuredHeight / 2;
        }
    }

    public final void j0(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.x, this.g0.getListPaddingLeft() + this.g0.getListPaddingRight(), layoutParams.width);
        int i2 = layoutParams.height;
        if (i2 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    public boolean k0(MotionEvent motionEvent) {
        motionEvent.getAction();
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            if (this.t == 4) {
                y0(false);
            }
            V();
        } else if (action == 2) {
            T((int) motionEvent.getX(), (int) motionEvent.getY());
        } else if (action == 3) {
            if (this.t == 4) {
                R();
            }
            V();
        }
        return true;
    }

    public void l0(int i2) {
        this.e0 = false;
        m0(i2, 0.0f);
    }

    public void m0(int i2, float f2) {
        int i3 = this.t;
        if (i3 == 0 || i3 == 4) {
            if (this.t == 0) {
                int headerViewsCount = this.g0.getHeaderViewsCount() + i2;
                this.m = headerViewsCount;
                this.j = headerViewsCount;
                this.k = headerViewsCount;
                this.f48126i = headerViewsCount;
                ListView listView = this.g0;
                View childAt = listView.getChildAt(headerViewsCount - listView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.t = 1;
            this.f0 = f2;
            if (this.P) {
                int i4 = this.S;
                if (i4 == 1) {
                    this.h0.onTouchEvent(this.R);
                } else if (i4 == 2) {
                    this.h0.onInterceptTouchEvent(this.R);
                }
            }
            m mVar = this.b0;
            if (mVar != null) {
                mVar.d();
            } else {
                Z(i2);
            }
        }
    }

    public final void n0(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.M = this.L;
        }
        this.K = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        this.L = y;
        if (action == 0) {
            this.M = y;
        }
        motionEvent.getRawX();
        motionEvent.getRawY();
    }

    public void o0(boolean z) {
        this.s = z;
    }

    @Override // d.a.i0.b1.e.c
    public void onDraw(Canvas canvas) {
        this.h0.onDraw(canvas);
        if (this.W) {
            this.X.a();
        }
    }

    @Override // d.a.i0.b1.e.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.s) {
            return this.h0.onInterceptTouchEvent(motionEvent);
        }
        d.a.i0.b1.e.b bVar = this.i0;
        if (bVar != null) {
            bVar.p().onTouchEvent(motionEvent);
        }
        n0(motionEvent);
        this.O = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.t != 0) {
                this.Z = true;
                return true;
            }
            this.P = true;
        }
        if (this.f48118a != null) {
            z = true;
        } else {
            if (this.h0.onInterceptTouchEvent(motionEvent)) {
                this.j0 = true;
                z = true;
            } else {
                z = false;
            }
            if (action == 1 || action == 3) {
                V();
            } else if (z) {
                this.S = 1;
            } else {
                this.S = 2;
            }
        }
        if (action == 1 || action == 3) {
            this.P = false;
        }
        return z;
    }

    @Override // d.a.i0.b1.e.c
    public void onMeasure(int i2, int i3) {
        this.h0.onMeasure(i2, i3);
        View view = this.f48118a;
        if (view != null) {
            if (view.isLayoutRequested()) {
                i0();
            }
            this.f48122e = true;
        }
        this.x = i2;
    }

    @Override // d.a.i0.b1.e.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.h0.onSizeChanged(i2, i3, i4, i5);
        D0();
    }

    @Override // d.a.i0.b1.e.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.Z) {
            this.Z = false;
            return false;
        } else if (!this.s) {
            return this.h0.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.O;
            this.O = false;
            if (!z2) {
                n0(motionEvent);
            }
            int i2 = this.t;
            if (i2 == 4) {
                k0(motionEvent);
                return true;
            }
            if (i2 == 0 && this.h0.onTouchEvent(motionEvent)) {
                z = true;
            }
            int action = motionEvent.getAction() & 255;
            if (action == 1 || action == 3) {
                V();
            } else if (z) {
                this.S = 1;
            }
            return z;
        }
    }

    public void p0(d dVar) {
        this.p = dVar;
    }

    public void q0(float f2) {
        r0(f2, f2);
    }

    public void r0(float f2, float f3) {
        if (f3 > 0.5f) {
            this.B = 0.5f;
        } else {
            this.B = f3;
        }
        if (f2 > 0.5f) {
            this.A = 0.5f;
        } else {
            this.A = f2;
        }
        if (this.g0.getHeight() != 0) {
            D0();
        }
    }

    @Override // d.a.i0.b1.e.c
    public void requestLayout() {
        if (this.Y) {
            return;
        }
        this.h0.requestLayout();
    }

    public void s0(d.a.i0.b1.e.b bVar) {
        this.i0 = bVar;
        this.g0.setOnTouchListener(bVar);
    }

    @Override // d.a.i0.b1.e.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.V = new c(listAdapter);
            listAdapter.registerDataSetObserver(this.f48123f);
            if (listAdapter instanceof i) {
                t0((i) listAdapter);
            }
            if (listAdapter instanceof d) {
                p0((d) listAdapter);
            }
            if (listAdapter instanceof n) {
                v0((n) listAdapter);
            }
        } else {
            this.V = null;
        }
        this.h0.setAdapter(this.V);
    }

    public void t0(i iVar) {
        this.q = iVar;
    }

    public void u0(j jVar) {
        this.Q = jVar;
    }

    public void v0(n nVar) {
        this.r = nVar;
    }

    public boolean w0(int i2, int i3, int i4, int i5) {
        j jVar;
        View b2;
        if (!this.P || (jVar = this.Q) == null || (b2 = jVar.b(i2)) == null) {
            return false;
        }
        return x0(i2, b2, i3, i4, i5);
    }

    public boolean x0(int i2, View view, int i3, int i4, int i5) {
        if (this.t == 0 && this.P && this.f48118a == null && view != null && this.s) {
            if (this.g0.getParent() != null) {
                this.g0.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = i2 + this.g0.getHeaderViewsCount();
            this.j = headerViewsCount;
            this.k = headerViewsCount;
            this.m = headerViewsCount;
            this.f48126i = headerViewsCount;
            this.t = 4;
            this.N = 0;
            this.N = i3 | 0;
            this.f48118a = view;
            i0();
            this.n = i4;
            this.o = i5;
            int i6 = this.L;
            Point point = this.f48119b;
            point.x = this.K - i4;
            point.y = i6 - i5;
            ListView listView = this.g0;
            View childAt = listView.getChildAt(this.m - listView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.W) {
                this.X.c();
            }
            int i7 = this.S;
            if (i7 == 1) {
                this.h0.onTouchEvent(this.R);
            } else if (i7 == 2) {
                this.h0.onInterceptTouchEvent(this.R);
            }
            this.g0.requestLayout();
            l lVar = this.c0;
            if (lVar != null) {
                lVar.d();
            }
            return true;
        }
        return false;
    }

    public boolean y0(boolean z) {
        this.e0 = false;
        return z0(z, 0.0f);
    }

    public boolean z0(boolean z, float f2) {
        if (this.f48118a != null) {
            this.z.d(true);
            if (z) {
                m0(this.m - this.g0.getHeaderViewsCount(), f2);
            } else {
                h hVar = this.d0;
                if (hVar != null) {
                    hVar.d();
                } else {
                    b0();
                }
            }
            if (this.W) {
                this.X.d();
            }
            return true;
        }
        return false;
    }
}
