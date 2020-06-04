package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] ngh = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] ngi;
    public static final /* synthetic */ int[] ngj;

    static {
        ngh[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        ngh[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        ngh[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        ngh[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        ngi = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        ngi[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        ngi[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        ngi[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        ngj = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        ngj[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        ngj[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        ngj[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
