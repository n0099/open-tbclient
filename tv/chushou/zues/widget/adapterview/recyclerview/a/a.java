package tv.chushou.zues.widget.adapterview.recyclerview.a;

import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.widget.adapterview.d;
import tv.chushou.zues.widget.adapterview.e;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes6.dex */
public abstract class a<T> extends RecyclerView.Adapter<View$OnLongClickListenerC1029a> {
    private List<T> data;
    private int ozJ;
    private d pmH;
    private e pmI;

    public abstract void a(View$OnLongClickListenerC1029a view$OnLongClickListenerC1029a, T t);

    public a(@LayoutRes int i, d dVar) {
        this(null, i, dVar);
    }

    public a(List<T> list, @LayoutRes int i, d dVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.ozJ = i;
        this.pmH = dVar;
    }

    public a(List<T> list, @LayoutRes int i, d dVar, e eVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.ozJ = i;
        this.pmH = dVar;
        this.pmI = eVar;
    }

    public void gq(List<T> list) {
        this.data.clear();
        if (list != null) {
            this.data.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: Q */
    public View$OnLongClickListenerC1029a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new View$OnLongClickListenerC1029a(LayoutInflater.from(viewGroup.getContext()).inflate(OC(i), viewGroup, false), this.pmH, this.pmI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int OC(int i) {
        return this.ozJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(View$OnLongClickListenerC1029a view$OnLongClickListenerC1029a, int i) {
        a(view$OnLongClickListenerC1029a, (View$OnLongClickListenerC1029a) this.data.get(i), i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull View$OnLongClickListenerC1029a view$OnLongClickListenerC1029a, int i, @NonNull List<Object> list) {
        onBindViewHolder(view$OnLongClickListenerC1029a, i);
    }

    public T getItem(int i) {
        if (this.data == null || i >= this.data.size()) {
            return null;
        }
        return this.data.get(i);
    }

    public void a(View$OnLongClickListenerC1029a view$OnLongClickListenerC1029a, T t, int i) {
        a(view$OnLongClickListenerC1029a, (View$OnLongClickListenerC1029a) t);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.recyclerview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class View$OnLongClickListenerC1029a extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private final View.OnClickListener mOnClickListener;
        private SparseArray<View> ozT;
        private d pmH;
        private e pmI;

        public View$OnLongClickListenerC1029a(View view, d dVar, e eVar) {
            super(view);
            this.mOnClickListener = new tv.chushou.zues.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.a.a.1
                @Override // tv.chushou.zues.a
                public void dP(View view2) {
                    if (View$OnLongClickListenerC1029a.this.pmH != null) {
                        View$OnLongClickListenerC1029a.this.pmH.E(view2, View$OnLongClickListenerC1029a.this.getLayoutPosition());
                    }
                }
            };
            this.pmH = dVar;
            this.pmI = eVar;
            this.ozT = new SparseArray<>();
            view.setOnClickListener(this.mOnClickListener);
            view.setOnLongClickListener(this);
        }

        public <V extends View> V rL(int i) {
            V v = (V) this.ozT.get(i);
            if (v == null) {
                V v2 = (V) this.itemView.findViewById(i);
                this.ozT.put(i, v2);
                return v2;
            }
            return v;
        }

        public View$OnLongClickListenerC1029a a(int i, CharSequence charSequence) {
            TextView textView = (TextView) rL(i);
            if (textView != null) {
                textView.setText(charSequence);
            }
            return this;
        }

        public View$OnLongClickListenerC1029a et(int i, @ColorInt int i2) {
            TextView textView = (TextView) rL(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC1029a a(int i, ColorStateList colorStateList) {
            TextView textView = (TextView) rL(i);
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            return this;
        }

        public View$OnLongClickListenerC1029a eu(int i, @DrawableRes int i2) {
            ImageView imageView = (ImageView) rL(i);
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC1029a a(int i, String str, int i2, int i3, int i4) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) rL(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.i(str, i2, i3, i4);
            }
            return this;
        }

        public View$OnLongClickListenerC1029a a(int i, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) rL(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.setGray(z);
                frescoThumbnailView.setAnim(z2);
                frescoThumbnailView.a(str, i2, i3, i4, i5);
            }
            return this;
        }

        public View$OnLongClickListenerC1029a a(boolean z, int... iArr) {
            for (int i : iArr) {
                View rL = rL(i);
                if (rL != null) {
                    rL.setVisibility(z ? 0 : 8);
                }
            }
            return this;
        }

        public View$OnLongClickListenerC1029a t(int... iArr) {
            for (int i : iArr) {
                View rL = rL(i);
                if (rL != null) {
                    rL.setOnClickListener(this.mOnClickListener);
                }
            }
            return this;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.pmI != null) {
                this.pmI.F(view, getLayoutPosition());
                return false;
            }
            return false;
        }
    }
}
