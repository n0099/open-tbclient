package d.a.n0.v.d.h.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.LayoutManager f65569a;

    /* loaded from: classes4.dex */
    public static class a extends d {
        public a(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
        }

        @Override // d.a.n0.v.d.h.a.d
        public int c(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f65569a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // d.a.n0.v.d.h.a.d
        public int d(View view) {
            return this.f65569a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // d.a.n0.v.d.h.a.d
        public int e() {
            return this.f65569a.getWidth();
        }

        @Override // d.a.n0.v.d.h.a.d
        public int f() {
            return this.f65569a.getPaddingLeft();
        }

        @Override // d.a.n0.v.d.h.a.d
        public int g() {
            return (this.f65569a.getWidth() - this.f65569a.getPaddingLeft()) - this.f65569a.getPaddingRight();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d {
        public b(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
        }

        @Override // d.a.n0.v.d.h.a.d
        public int c(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f65569a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // d.a.n0.v.d.h.a.d
        public int d(View view) {
            return this.f65569a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // d.a.n0.v.d.h.a.d
        public int e() {
            return this.f65569a.getHeight();
        }

        @Override // d.a.n0.v.d.h.a.d
        public int f() {
            return this.f65569a.getPaddingTop();
        }

        @Override // d.a.n0.v.d.h.a.d
        public int g() {
            return (this.f65569a.getHeight() - this.f65569a.getPaddingTop()) - this.f65569a.getPaddingBottom();
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
        this.f65569a = layoutManager;
    }
}
