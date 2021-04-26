package d.a.j0.t.d.h.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.LayoutManager f60842a;

    /* loaded from: classes4.dex */
    public static class a extends d {
        public a(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
        }

        @Override // d.a.j0.t.d.h.a.d
        public int c(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f60842a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // d.a.j0.t.d.h.a.d
        public int d(View view) {
            return this.f60842a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // d.a.j0.t.d.h.a.d
        public int e() {
            return this.f60842a.getWidth();
        }

        @Override // d.a.j0.t.d.h.a.d
        public int f() {
            return this.f60842a.getPaddingLeft();
        }

        @Override // d.a.j0.t.d.h.a.d
        public int g() {
            return (this.f60842a.getWidth() - this.f60842a.getPaddingLeft()) - this.f60842a.getPaddingRight();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d {
        public b(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
        }

        @Override // d.a.j0.t.d.h.a.d
        public int c(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f60842a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // d.a.j0.t.d.h.a.d
        public int d(View view) {
            return this.f60842a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // d.a.j0.t.d.h.a.d
        public int e() {
            return this.f60842a.getHeight();
        }

        @Override // d.a.j0.t.d.h.a.d
        public int f() {
            return this.f60842a.getPaddingTop();
        }

        @Override // d.a.j0.t.d.h.a.d
        public int g() {
            return (this.f60842a.getHeight() - this.f60842a.getPaddingTop()) - this.f60842a.getPaddingBottom();
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
        this.f60842a = layoutManager;
    }
}
