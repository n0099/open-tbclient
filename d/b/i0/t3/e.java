package d.b.i0.t3;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class e extends ShapeDrawable {

    /* renamed from: a  reason: collision with root package name */
    public int f61168a;

    public e(Path path, float f2, float f3) {
        super(new PathShape(path, f2, f3));
        this.f61168a = TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0201);
    }

    public void a(int i) {
        this.f61168a = i;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        getPaint().setColor(this.f61168a);
        super.draw(canvas);
    }
}
