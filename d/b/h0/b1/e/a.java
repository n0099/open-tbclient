package d.b.h0.b1.e;

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
public class a implements d.b.h0.b1.e.c {
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
    public View f50225a;
    public m b0;
    public l c0;

    /* renamed from: d  reason: collision with root package name */
    public int f50228d;
    public h d0;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f50230f;
    public ListView g0;
    public d.b.h0.b1.e.d h0;
    public int i;
    public d.b.h0.b1.e.b i0;
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
    public Point f50226b = new Point();

    /* renamed from: c  reason: collision with root package name */
    public Point f50227c = new Point();

    /* renamed from: e  reason: collision with root package name */
    public boolean f50229e = false;

    /* renamed from: g  reason: collision with root package name */
    public float f50231g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f50232h = 1.0f;
    public boolean l = false;
    public boolean s = true;
    public int t = 0;
    public int u = 1;
    public int x = 0;
    public View[] y = new View[1];
    public float A = 0.33333334f;
    public float B = 0.33333334f;
    public float I = 0.5f;
    public e J = new C1060a();
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

    /* renamed from: d.b.h0.b1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1060a implements e {
        public C1060a() {
        }

        @Override // d.b.h0.b1.e.a.e
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
                a.this.S();
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
        public ListAdapter f50235e;

        /* renamed from: d.b.h0.b1.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1061a extends DataSetObserver {
            public C1061a(a aVar) {
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
            this.f50235e = listAdapter;
            listAdapter.registerDataSetObserver(new C1061a(a.this));
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.f50235e.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f50235e.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f50235e.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.f50235e.getItemId(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return this.f50235e.getItemViewType(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            DragSortItemView dragSortItemView;
            DragSortItemView dragSortItemView2;
            if (view != null) {
                dragSortItemView2 = (DragSortItemView) view;
                View childAt = dragSortItemView2.getChildAt(0);
                View view2 = this.f50235e.getView(i, childAt, a.this.g0);
                if (view2 != childAt) {
                    if (childAt != null) {
                        dragSortItemView2.removeViewAt(0);
                    }
                    dragSortItemView2.addView(view2);
                }
            } else {
                View view3 = this.f50235e.getView(i, null, a.this.g0);
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
            aVar.N(i + aVar.g0.getHeaderViewsCount(), dragSortItemView2, true);
            return dragSortItemView2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.f50235e.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.f50235e.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.f50235e.isEmpty();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return this.f50235e.isEnabled(i);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void drag(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface e {
        float a(float f2, long j);
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public boolean f50238e;

        /* renamed from: f  reason: collision with root package name */
        public long f50239f;

        /* renamed from: g  reason: collision with root package name */
        public long f50240g;

        /* renamed from: h  reason: collision with root package name */
        public int f50241h;
        public float i;
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

        public void c(int i) {
            if (this.m) {
                return;
            }
            this.f50238e = false;
            this.m = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.j = uptimeMillis;
            this.f50239f = uptimeMillis;
            this.k = i;
            a.this.g0.post(this);
        }

        public void d(boolean z) {
            if (z) {
                a.this.g0.removeCallbacks(this);
                this.m = false;
                return;
            }
            this.f50238e = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f50238e) {
                int firstVisiblePosition = a.this.g0.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.g0.getLastVisiblePosition();
                int count = a.this.g0.getCount();
                int paddingTop = a.this.g0.getPaddingTop();
                int height = (a.this.g0.getHeight() - paddingTop) - a.this.g0.getPaddingBottom();
                int min = Math.min(a.this.L, a.this.f50228d + a.this.w);
                int max = Math.max(a.this.L, a.this.f50228d - a.this.w);
                if (this.k == 0) {
                    View childAt = a.this.g0.getChildAt(0);
                    if (childAt == null) {
                        this.m = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.m = false;
                        return;
                    } else {
                        this.l = a.this.J.a((a.this.F - max) / a.this.G, this.f50239f);
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
                        this.l = -a.this.J.a((min - a.this.E) / a.this.H, this.f50239f);
                    }
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f50240g = uptimeMillis;
                float f2 = (float) (uptimeMillis - this.f50239f);
                this.i = f2;
                int round = Math.round(this.l * f2);
                this.f50241h = round;
                if (round >= 0) {
                    this.f50241h = Math.min(height, round);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.f50241h = Math.max(-height, round);
                }
                View childAt3 = a.this.g0.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.f50241h;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.Y = true;
                a.this.g0.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.a();
                a.this.g0.invalidate();
                a.this.Y = false;
                a.this.X(lastVisiblePosition, childAt3, false);
                this.f50239f = this.f50240g;
                a.this.g0.post(this);
                return;
            }
            this.m = false;
        }
    }

    /* loaded from: classes3.dex */
    public class g {

        /* renamed from: b  reason: collision with root package name */
        public File f50243b;

        /* renamed from: a  reason: collision with root package name */
        public StringBuilder f50242a = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        public int f50244c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f50245d = 0;

        /* renamed from: e  reason: collision with root package name */
        public boolean f50246e = false;

        public g() {
            File file = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
            this.f50243b = file;
            if (file.exists()) {
                return;
            }
            try {
                this.f50243b.createNewFile();
                Log.d("mobeta", "file created");
            } catch (IOException e2) {
                Log.w("mobeta", "Could not create dslv_state.txt");
                Log.d("mobeta", e2.getMessage());
            }
        }

        public void a() {
            if (this.f50246e) {
                this.f50242a.append("<DSLVState>\n");
                int childCount = a.this.g0.getChildCount();
                int firstVisiblePosition = a.this.g0.getFirstVisiblePosition();
                this.f50242a.append("    <Positions>");
                for (int i = 0; i < childCount; i++) {
                    StringBuilder sb = this.f50242a;
                    sb.append(firstVisiblePosition + i);
                    sb.append(",");
                }
                this.f50242a.append("</Positions>\n");
                this.f50242a.append("    <Tops>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    StringBuilder sb2 = this.f50242a;
                    sb2.append(a.this.g0.getChildAt(i2).getTop());
                    sb2.append(",");
                }
                this.f50242a.append("</Tops>\n");
                this.f50242a.append("    <Bottoms>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    StringBuilder sb3 = this.f50242a;
                    sb3.append(a.this.g0.getChildAt(i3).getBottom());
                    sb3.append(",");
                }
                this.f50242a.append("</Bottoms>\n");
                StringBuilder sb4 = this.f50242a;
                sb4.append("    <FirstExpPos>");
                sb4.append(a.this.j);
                sb4.append("</FirstExpPos>\n");
                StringBuilder sb5 = this.f50242a;
                sb5.append("    <FirstExpBlankHeight>");
                a aVar = a.this;
                int f0 = aVar.f0(aVar.j);
                a aVar2 = a.this;
                sb5.append(f0 - aVar2.d0(aVar2.j));
                sb5.append("</FirstExpBlankHeight>\n");
                StringBuilder sb6 = this.f50242a;
                sb6.append("    <SecondExpPos>");
                sb6.append(a.this.k);
                sb6.append("</SecondExpPos>\n");
                StringBuilder sb7 = this.f50242a;
                sb7.append("    <SecondExpBlankHeight>");
                a aVar3 = a.this;
                int f02 = aVar3.f0(aVar3.k);
                a aVar4 = a.this;
                sb7.append(f02 - aVar4.d0(aVar4.k));
                sb7.append("</SecondExpBlankHeight>\n");
                StringBuilder sb8 = this.f50242a;
                sb8.append("    <SrcPos>");
                sb8.append(a.this.m);
                sb8.append("</SrcPos>\n");
                StringBuilder sb9 = this.f50242a;
                sb9.append("    <SrcHeight>");
                sb9.append(a.this.v + a.this.g0.getDividerHeight());
                sb9.append("</SrcHeight>\n");
                StringBuilder sb10 = this.f50242a;
                sb10.append("    <ViewHeight>");
                sb10.append(a.this.g0.getHeight());
                sb10.append("</ViewHeight>\n");
                StringBuilder sb11 = this.f50242a;
                sb11.append("    <LastY>");
                sb11.append(a.this.M);
                sb11.append("</LastY>\n");
                StringBuilder sb12 = this.f50242a;
                sb12.append("    <FloatY>");
                sb12.append(a.this.f50228d);
                sb12.append("</FloatY>\n");
                this.f50242a.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    StringBuilder sb13 = this.f50242a;
                    a aVar5 = a.this;
                    sb13.append(aVar5.g0(firstVisiblePosition + i4, aVar5.g0.getChildAt(i4).getTop()));
                    sb13.append(",");
                }
                this.f50242a.append("</ShuffleEdges>\n");
                this.f50242a.append("</DSLVState>\n");
                int i5 = this.f50244c + 1;
                this.f50244c = i5;
                if (i5 > 1000) {
                    b();
                    this.f50244c = 0;
                }
            }
        }

        public void b() {
            if (this.f50246e) {
                try {
                    FileWriter fileWriter = new FileWriter(this.f50243b, this.f50245d != 0);
                    fileWriter.write(this.f50242a.toString());
                    this.f50242a.delete(0, this.f50242a.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.f50245d++;
                } catch (IOException unused) {
                }
            }
        }

        public void c() {
            this.f50242a.append("<DSLVStates>\n");
            this.f50245d = 0;
            this.f50246e = true;
        }

        public void d() {
            if (this.f50246e) {
                this.f50242a.append("</DSLVStates>\n");
                b();
                this.f50246e = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends o {
        public int n;
        public int o;
        public float p;
        public float q;

        public h(float f2, int i) {
            super(f2, i);
        }

        @Override // d.b.h0.b1.e.a.o
        public void a() {
            this.n = a.this.i;
            this.o = a.this.m;
            a.this.t = 2;
            this.p = a.this.f50226b.y - f();
            this.q = a.this.f50226b.x - a.this.g0.getPaddingLeft();
        }

        @Override // d.b.h0.b1.e.a.o
        public void b() {
            a.this.c0();
        }

        @Override // d.b.h0.b1.e.a.o
        public void c(float f2, float f3) {
            int f4 = f();
            float paddingLeft = a.this.f50226b.x - a.this.g0.getPaddingLeft();
            float f5 = 1.0f - f3;
            if (f5 < Math.abs((a.this.f50226b.y - f4) / this.p) || f5 < Math.abs(paddingLeft / this.q)) {
                a.this.f50226b.y = f4 + ((int) (this.p * f5));
                a.this.f50226b.x = a.this.g0.getPaddingLeft() + ((int) (this.q * f5));
                a.this.Y(true);
            }
        }

        public final int f() {
            int bottom;
            int firstVisiblePosition = a.this.g0.getFirstVisiblePosition();
            int dividerHeight = (a.this.u + a.this.g0.getDividerHeight()) / 2;
            View childAt = a.this.g0.getChildAt(this.n - firstVisiblePosition);
            if (childAt != null) {
                int i = this.n;
                int i2 = this.o;
                if (i == i2) {
                    return childAt.getTop();
                }
                if (i < i2) {
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
        void drop(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(View view);

        View b(int i);

        void c(View view, Point point, Point point2);
    }

    /* loaded from: classes3.dex */
    public class k {

        /* renamed from: a  reason: collision with root package name */
        public SparseIntArray f50248a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Integer> f50249b;

        /* renamed from: c  reason: collision with root package name */
        public int f50250c;

        public k(a aVar, int i) {
            this.f50248a = new SparseIntArray(i);
            this.f50249b = new ArrayList<>(i);
            this.f50250c = i;
        }

        public void a(int i, int i2) {
            int i3 = this.f50248a.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.f50248a.size() == this.f50250c) {
                        this.f50248a.delete(this.f50249b.remove(0).intValue());
                    }
                } else {
                    this.f50249b.remove(Integer.valueOf(i));
                }
                this.f50248a.put(i, i2);
                this.f50249b.add(Integer.valueOf(i));
            }
        }

        public void b() {
            this.f50248a.clear();
            this.f50249b.clear();
        }

        public int c(int i) {
            return this.f50248a.get(i, -1);
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

        public m(float f2, int i) {
            super(f2, i);
            this.q = -1;
            this.r = -1;
        }

        @Override // d.b.h0.b1.e.a.o
        public void a() {
            this.q = -1;
            this.r = -1;
            this.s = a.this.j;
            this.t = a.this.k;
            int unused = a.this.m;
            a.this.t = 1;
            this.n = a.this.f50226b.x;
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
            a.this.V();
        }

        @Override // d.b.h0.b1.e.a.o
        public void b() {
            a.this.Z();
        }

        @Override // d.b.h0.b1.e.a.o
        public void c(float f2, float f3) {
            View childAt;
            float f4 = 1.0f - f3;
            int firstVisiblePosition = a.this.g0.getFirstVisiblePosition();
            View childAt2 = a.this.g0.getChildAt(this.s - firstVisiblePosition);
            if (a.this.e0) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f50251e)) / 1000.0f;
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
                Point point = a.this.f50226b;
                float f8 = this.n;
                point.x = (int) f8;
                if (f8 < f7 && f8 > (-width)) {
                    this.f50251e = SystemClock.uptimeMillis();
                    a.this.Y(true);
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.q == -1) {
                    this.q = a.this.e0(this.s, childAt2, false);
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
                this.r = a.this.e0(this.t, childAt, false);
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
        void remove(int i);
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f50251e;

        /* renamed from: f  reason: collision with root package name */
        public float f50252f;

        /* renamed from: g  reason: collision with root package name */
        public float f50253g;

        /* renamed from: h  reason: collision with root package name */
        public float f50254h;
        public float i;
        public float j;
        public float k;
        public boolean l;

        public o(float f2, int i) {
            this.f50253g = f2;
            this.f50252f = i;
            float f3 = 1.0f / ((f2 * 2.0f) * (1.0f - f2));
            this.k = f3;
            this.f50254h = f3;
            this.i = f2 / ((f2 - 1.0f) * 2.0f);
            this.j = 1.0f / (1.0f - f2);
        }

        public abstract void a();

        public abstract void b();

        public abstract void c(float f2, float f3);

        public void cancel() {
            this.l = true;
        }

        public void d() {
            this.f50251e = SystemClock.uptimeMillis();
            this.l = false;
            a();
            a.this.g0.post(this);
        }

        public float e(float f2) {
            float f3 = this.f50253g;
            if (f2 < f3) {
                return this.f50254h * f2 * f2;
            }
            if (f2 < 1.0f - f3) {
                return this.i + (this.j * f2);
            }
            float f4 = f2 - 1.0f;
            return 1.0f - ((this.k * f4) * f4);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.l) {
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f50251e)) / this.f50252f;
            if (uptimeMillis >= 1.0f) {
                c(1.0f, 1.0f);
                b();
                return;
            }
            c(uptimeMillis, e(uptimeMillis));
            a.this.g0.post(this);
        }
    }

    public a(ListView listView, d.b.h0.b1.e.d dVar) {
        this.h0 = dVar;
        this.g0 = listView;
    }

    public boolean A0(boolean z, float f2) {
        if (this.f50225a != null) {
            this.z.d(true);
            if (z) {
                n0(this.m - this.g0.getHeaderViewsCount(), f2);
            } else {
                h hVar = this.d0;
                if (hVar != null) {
                    hVar.d();
                } else {
                    c0();
                }
            }
            if (this.W) {
                this.X.d();
            }
            return true;
        }
        return false;
    }

    public boolean B0(boolean z, float f2) {
        this.e0 = true;
        return A0(z, f2);
    }

    public final void C0() {
        int i2;
        int i3;
        if (this.Q != null) {
            this.f50227c.set(this.K, this.L);
            this.Q.c(this.f50225a, this.f50226b, this.f50227c);
        }
        Point point = this.f50226b;
        int i4 = point.x;
        int i5 = point.y;
        int paddingLeft = this.g0.getPaddingLeft();
        if ((this.N & 1) == 0 && i4 > paddingLeft) {
            this.f50226b.x = paddingLeft;
        } else if ((this.N & 2) == 0 && i4 < paddingLeft) {
            this.f50226b.x = paddingLeft;
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
            this.f50226b.y = paddingTop;
        } else {
            int i6 = this.v;
            if (i5 + i6 > height) {
                this.f50226b.y = height - i6;
            }
        }
        this.f50228d = this.f50226b.y + this.w;
    }

    public final boolean D0() {
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
        int g0 = g0(i4, top);
        int dividerHeight = this.g0.getDividerHeight();
        if (this.f50228d < g0) {
            while (i4 >= 0) {
                i4--;
                int f0 = f0(i4);
                if (i4 == 0) {
                    i2 = (top - dividerHeight) - f0;
                    int i5 = g0;
                    g0 = i2;
                    i3 = i5;
                    break;
                }
                top -= f0 + dividerHeight;
                int g02 = g0(i4, top);
                if (this.f50228d >= g02) {
                    i3 = g0;
                    g0 = g02;
                    break;
                }
                g0 = g02;
            }
            i3 = g0;
        } else {
            int count = this.g0.getCount();
            while (i4 < count) {
                if (i4 == count - 1) {
                    i2 = top + dividerHeight + height;
                    int i52 = g0;
                    g0 = i2;
                    i3 = i52;
                    break;
                }
                top += height + dividerHeight;
                int i6 = i4 + 1;
                int f02 = f0(i6);
                int g03 = g0(i6, top);
                if (this.f50228d < g03) {
                    i3 = g0;
                    g0 = g03;
                    break;
                }
                i4 = i6;
                height = f02;
                g0 = g03;
            }
            i3 = g0;
        }
        int headerViewsCount = this.g0.getHeaderViewsCount();
        int footerViewsCount = this.g0.getFooterViewsCount();
        boolean z = false;
        int i7 = this.j;
        int i8 = this.k;
        float f2 = this.U;
        if (this.l) {
            int abs = Math.abs(g0 - i3);
            if (this.f50228d < g0) {
                int i9 = g0;
                g0 = i3;
                i3 = i9;
            }
            int i10 = (int) (this.T * 0.5f * abs);
            float f3 = i10;
            int i11 = g0 + i10;
            int i12 = i3 - i10;
            int i13 = this.f50228d;
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
        int i14 = this.i;
        if (i4 != i14) {
            d dVar = this.p;
            if (dVar != null) {
                dVar.drag(i14 - headerViewsCount, i4 - headerViewsCount);
            }
            this.i = i4;
            return true;
        }
        return z;
    }

    public final void E0() {
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

    public final void M() {
        int firstVisiblePosition = this.g0.getFirstVisiblePosition();
        int lastVisiblePosition = this.g0.getLastVisiblePosition();
        int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((this.g0.getCount() - 1) - this.g0.getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, this.g0.getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
            View childAt = this.g0.getChildAt(max);
            if (childAt != null) {
                N(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    public final void N(int i2, View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int R = (i2 == this.m || i2 == this.j || i2 == this.k) ? R(i2, view, z) : -2;
        if (R != layoutParams.height) {
            layoutParams.height = R;
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
        if (i2 == this.m && this.f50225a != null) {
            i4 = 4;
        }
        if (i4 != visibility) {
            view.setVisibility(i4);
        }
    }

    public final void O() {
        int firstVisiblePosition = this.g0.getFirstVisiblePosition();
        if (this.m < firstVisiblePosition) {
            View childAt = this.g0.getChildAt(0);
            int top = childAt != null ? childAt.getTop() : 0;
            ListView listView = this.g0;
            listView.setSelectionFromTop(firstVisiblePosition - 1, top - listView.getPaddingTop());
        }
    }

    public final int P(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int d0 = d0(i2);
        int height = view.getHeight();
        int Q = Q(i2, d0);
        if (i2 != this.m) {
            i5 = height - d0;
            i6 = Q - d0;
        } else {
            i5 = height;
            i6 = Q;
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
                return 0 + (height - Q);
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

    public final int Q(int i2, int i3) {
        this.g0.getDividerHeight();
        boolean z = this.l && this.j != this.k;
        int i4 = this.v;
        int i5 = this.u;
        int i6 = i4 - i5;
        int i7 = (int) (this.U * i6);
        int i8 = this.m;
        return i2 == i8 ? i8 == this.j ? z ? i7 + i5 : i4 : i8 == this.k ? i4 - i7 : i5 : i2 == this.j ? z ? i3 + i7 : i3 + i6 : i2 == this.k ? (i3 + i6) - i7 : i3;
    }

    public final int R(int i2, View view, boolean z) {
        return Q(i2, e0(i2, view, z));
    }

    public void S() {
        if (this.t == 4) {
            this.z.d(true);
            V();
            T();
            M();
            if (this.P) {
                this.t = 3;
            } else {
                this.t = 0;
            }
        }
    }

    public final void T() {
        this.m = -1;
        this.j = -1;
        this.k = -1;
        this.i = -1;
    }

    public final void U(int i2, int i3) {
        Point point = this.f50226b;
        point.x = i2 - this.n;
        point.y = i3 - this.o;
        Y(true);
        int min = Math.min(i3, this.f50228d + this.w);
        int max = Math.max(i3, this.f50228d - this.w);
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

    public final void V() {
        View view = this.f50225a;
        if (view != null) {
            view.setVisibility(8);
            j jVar = this.Q;
            if (jVar != null) {
                jVar.a(this.f50225a);
            }
            this.f50225a = null;
            this.g0.invalidate();
        }
    }

    public final void W() {
        this.S = 0;
        this.P = false;
        if (this.t == 3) {
            this.t = 0;
        }
        this.f50232h = this.f50231g;
        this.j0 = false;
        this.a0.b();
    }

    public final void X(int i2, View view, boolean z) {
        this.Y = true;
        C0();
        int i3 = this.j;
        int i4 = this.k;
        boolean D0 = D0();
        if (D0) {
            M();
            this.g0.setSelectionFromTop(i2, (view.getTop() + P(i2, view, i3, i4)) - this.g0.getPaddingTop());
            a();
        }
        if (D0 || z) {
            this.g0.invalidate();
        }
        this.Y = false;
    }

    public final void Y(boolean z) {
        int firstVisiblePosition = this.g0.getFirstVisiblePosition() + (this.g0.getChildCount() / 2);
        ListView listView = this.g0;
        View childAt = listView.getChildAt(listView.getChildCount() / 2);
        if (childAt == null) {
            return;
        }
        X(firstVisiblePosition, childAt, z);
    }

    public final void Z() {
        a0(this.m - this.g0.getHeaderViewsCount());
    }

    @Override // d.b.h0.b1.e.c
    public void a() {
        this.h0.a();
        View view = this.f50225a;
        if (view != null) {
            if (view.isLayoutRequested() && !this.f50229e) {
                j0();
            }
            View view2 = this.f50225a;
            view2.layout(0, 0, view2.getMeasuredWidth(), this.f50225a.getMeasuredHeight());
            this.f50229e = false;
        }
    }

    public final void a0(int i2) {
        this.t = 1;
        n nVar = this.r;
        if (nVar != null) {
            nVar.remove(i2);
        }
        V();
        O();
        T();
        if (this.P) {
            this.t = 3;
        } else {
            this.t = 0;
        }
    }

    @Override // d.b.h0.b1.e.c
    public void b(Canvas canvas) {
        float f2;
        this.h0.b(canvas);
        if (this.t != 0) {
            int i2 = this.j;
            if (i2 != this.m) {
                b0(i2, canvas);
            }
            int i3 = this.k;
            if (i3 != this.j && i3 != this.m) {
                b0(i3, canvas);
            }
        }
        View view = this.f50225a;
        if (view != null) {
            int width = view.getWidth();
            int height = this.f50225a.getHeight();
            int i4 = this.f50226b.x;
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
            Point point = this.f50226b;
            canvas.translate(point.x, point.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, (int) (this.f50232h * 255.0f * f2), 31);
            this.f50225a.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    public final void b0(int i2, Canvas canvas) {
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

    @Override // d.b.h0.b1.e.c
    public void c(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.V = new c(listAdapter);
            listAdapter.registerDataSetObserver(this.f50230f);
            if (listAdapter instanceof i) {
                u0((i) listAdapter);
            }
            if (listAdapter instanceof d) {
                q0((d) listAdapter);
            }
            if (listAdapter instanceof n) {
                w0((n) listAdapter);
            }
        } else {
            this.V = null;
        }
        this.h0.c(this.V);
    }

    public final void c0() {
        int i2;
        this.t = 2;
        if (this.q != null && (i2 = this.i) >= 0 && i2 < this.g0.getCount()) {
            int headerViewsCount = this.g0.getHeaderViewsCount();
            this.q.drop(this.m - headerViewsCount, this.i - headerViewsCount);
        }
        V();
        O();
        T();
        M();
        if (this.P) {
            this.t = 3;
        } else {
            this.t = 0;
        }
    }

    @Override // d.b.h0.b1.e.c
    public void d(ListView listView, Context context, AttributeSet attributeSet) {
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
            float f2 = obtainStyledAttributes.getFloat(R$styleable.DragSort_float_alpha, this.f50231g);
            this.f50231g = f2;
            this.f50232h = f2;
            this.s = obtainStyledAttributes.getBoolean(R$styleable.DragSort_drag_enabled, this.s);
            float max = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R$styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.T = max;
            this.l = max > 0.0f;
            r0(obtainStyledAttributes.getFloat(R$styleable.DragSort_drag_scroll_start, this.A));
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
                d.b.h0.b1.e.b bVar = new d.b.h0.b1.e.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.r(z2);
                bVar.t(z3);
                bVar.d(color);
                this.Q = bVar;
                t0(bVar);
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
        this.f50230f = new b();
    }

    public final int d0(int i2) {
        View view;
        if (i2 == this.m) {
            return 0;
        }
        ListView listView = this.g0;
        View childAt = listView.getChildAt(i2 - listView.getFirstVisiblePosition());
        if (childAt != null) {
            return e0(i2, childAt, false);
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
        int e0 = e0(i2, view, true);
        this.a0.a(i2, e0);
        return e0;
    }

    public final int e0(int i2, View view, boolean z) {
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
                k0(view);
                return view.getMeasuredHeight();
            }
            return height;
        }
        return i3;
    }

    public final int f0(int i2) {
        ListView listView = this.g0;
        View childAt = listView.getChildAt(i2 - listView.getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return Q(i2, d0(i2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        if (r8 <= r7.m) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int g0(int i2, int i3) {
        int headerViewsCount = this.g0.getHeaderViewsCount();
        int footerViewsCount = this.g0.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.g0.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.g0.getDividerHeight();
        int i4 = this.v - this.u;
        int d0 = d0(i2);
        int f0 = f0(i2);
        int i5 = this.k;
        int i6 = this.m;
        if (i5 <= i6) {
            if (i2 != i5 || this.j == i5) {
                if (i2 > this.k) {
                }
            } else if (i2 == i6) {
                i3 += f0;
                i4 = this.v;
            } else {
                i3 += f0 - d0;
            }
            i3 -= i4;
        } else if (i2 <= i6 || i2 > this.j) {
            int i7 = this.k;
            if (i2 == i7 && this.j != i7) {
                i3 += f0 - d0;
            }
        } else {
            i3 += i4;
        }
        if (i2 <= this.m) {
            return i3 + (((this.v - dividerHeight) - d0(i2 - 1)) / 2);
        }
        return i3 + (((d0 - dividerHeight) - this.v) / 2);
    }

    public boolean h0() {
        return this.s;
    }

    public boolean i0() {
        return this.j0;
    }

    public final void j0() {
        View view = this.f50225a;
        if (view != null) {
            k0(view);
            int measuredHeight = this.f50225a.getMeasuredHeight();
            this.v = measuredHeight;
            this.w = measuredHeight / 2;
        }
    }

    public final void k0(View view) {
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

    public boolean l0(MotionEvent motionEvent) {
        motionEvent.getAction();
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            if (this.t == 4) {
                z0(false);
            }
            W();
        } else if (action == 2) {
            U((int) motionEvent.getX(), (int) motionEvent.getY());
        } else if (action == 3) {
            if (this.t == 4) {
                S();
            }
            W();
        }
        return true;
    }

    public void m0(int i2) {
        this.e0 = false;
        n0(i2, 0.0f);
    }

    public void n0(int i2, float f2) {
        int i3 = this.t;
        if (i3 == 0 || i3 == 4) {
            if (this.t == 0) {
                int headerViewsCount = this.g0.getHeaderViewsCount() + i2;
                this.m = headerViewsCount;
                this.j = headerViewsCount;
                this.k = headerViewsCount;
                this.i = headerViewsCount;
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
                a0(i2);
            }
        }
    }

    public final void o0(MotionEvent motionEvent) {
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

    @Override // d.b.h0.b1.e.c
    public void onDraw(Canvas canvas) {
        this.h0.onDraw(canvas);
        if (this.W) {
            this.X.a();
        }
    }

    @Override // d.b.h0.b1.e.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.s) {
            return this.h0.onInterceptTouchEvent(motionEvent);
        }
        d.b.h0.b1.e.b bVar = this.i0;
        if (bVar != null) {
            bVar.p().onTouchEvent(motionEvent);
        }
        o0(motionEvent);
        this.O = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.t != 0) {
                this.Z = true;
                return true;
            }
            this.P = true;
        }
        if (this.f50225a != null) {
            z = true;
        } else {
            if (this.h0.onInterceptTouchEvent(motionEvent)) {
                this.j0 = true;
                z = true;
            } else {
                z = false;
            }
            if (action == 1 || action == 3) {
                W();
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

    @Override // d.b.h0.b1.e.c
    public void onMeasure(int i2, int i3) {
        this.h0.onMeasure(i2, i3);
        View view = this.f50225a;
        if (view != null) {
            if (view.isLayoutRequested()) {
                j0();
            }
            this.f50229e = true;
        }
        this.x = i2;
    }

    @Override // d.b.h0.b1.e.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.h0.onSizeChanged(i2, i3, i4, i5);
        E0();
    }

    @Override // d.b.h0.b1.e.c
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
                o0(motionEvent);
            }
            int i2 = this.t;
            if (i2 == 4) {
                l0(motionEvent);
                return true;
            }
            if (i2 == 0 && this.h0.onTouchEvent(motionEvent)) {
                z = true;
            }
            int action = motionEvent.getAction() & 255;
            if (action == 1 || action == 3) {
                W();
            } else if (z) {
                this.S = 1;
            }
            return z;
        }
    }

    public void p0(boolean z) {
        this.s = z;
    }

    public void q0(d dVar) {
        this.p = dVar;
    }

    public void r0(float f2) {
        s0(f2, f2);
    }

    @Override // d.b.h0.b1.e.c
    public void requestLayout() {
        if (this.Y) {
            return;
        }
        this.h0.requestLayout();
    }

    public void s0(float f2, float f3) {
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
            E0();
        }
    }

    public void t0(d.b.h0.b1.e.b bVar) {
        this.i0 = bVar;
        this.g0.setOnTouchListener(bVar);
    }

    public void u0(i iVar) {
        this.q = iVar;
    }

    public void v0(j jVar) {
        this.Q = jVar;
    }

    public void w0(n nVar) {
        this.r = nVar;
    }

    public boolean x0(int i2, int i3, int i4, int i5) {
        j jVar;
        View b2;
        if (!this.P || (jVar = this.Q) == null || (b2 = jVar.b(i2)) == null) {
            return false;
        }
        return y0(i2, b2, i3, i4, i5);
    }

    public boolean y0(int i2, View view, int i3, int i4, int i5) {
        if (this.t == 0 && this.P && this.f50225a == null && view != null && this.s) {
            if (this.g0.getParent() != null) {
                this.g0.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = i2 + this.g0.getHeaderViewsCount();
            this.j = headerViewsCount;
            this.k = headerViewsCount;
            this.m = headerViewsCount;
            this.i = headerViewsCount;
            this.t = 4;
            this.N = 0;
            this.N = i3 | 0;
            this.f50225a = view;
            j0();
            this.n = i4;
            this.o = i5;
            int i6 = this.L;
            Point point = this.f50226b;
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

    public boolean z0(boolean z) {
        this.e0 = false;
        return A0(z, 0.0f);
    }
}
