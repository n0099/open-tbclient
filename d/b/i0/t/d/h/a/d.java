package d.b.i0.t.d.h.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.LayoutManager f60669a;

    /* loaded from: classes4.dex */
    public static class a extends d {
        public a(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
        }

        @Override // d.b.i0.t.d.h.a.d
        public int c(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f60669a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // d.b.i0.t.d.h.a.d
        public int d(View view) {
            return this.f60669a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // d.b.i0.t.d.h.a.d
        public int e() {
            return this.f60669a.getWidth();
        }

        @Override // d.b.i0.t.d.h.a.d
        public int f() {
            return this.f60669a.getPaddingLeft();
        }

        @Override // d.b.i0.t.d.h.a.d
        public int g() {
            return (this.f60669a.getWidth() - this.f60669a.getPaddingLeft()) - this.f60669a.getPaddingRight();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d {
        public b(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
        }

        @Override // d.b.i0.t.d.h.a.d
        public int c(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f60669a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // d.b.i0.t.d.h.a.d
        public int d(View view) {
            return this.f60669a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // d.b.i0.t.d.h.a.d
        public int e() {
            return this.f60669a.getHeight();
        }

        @Override // d.b.i0.t.d.h.a.d
        public int f() {
            return this.f60669a.getPaddingTop();
        }

        @Override // d.b.i0.t.d.h.a.d
        public int g() {
            return (this.f60669a.getHeight() - this.f60669a.getPaddingTop()) - this.f60669a.getPaddingBottom();
        }
    }

    public /* synthetic */ d(RecyclerView.LayoutManager layoutManager, a aVar) {
        this(layoutManager);
    }

    public static d a(RecyclerView.LayoutManager layoutManager) {
        return new a(layoutManager);
    }

    public static d b(RecyclerView.LayoutManager layoutManager) {
        return new b(layoutManager);
    }

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public d(RecyclerView.LayoutManager layoutManager) {
        new Rect();
        this.f60669a = layoutManager;
    }
}
