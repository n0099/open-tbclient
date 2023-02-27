package com.googlecode.mp4parser.util;

import com.baidu.android.common.others.IStringUtil;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.AbstractContainerBox;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class Path {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Pattern component = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");

    public static String createPath(Box box) {
        return createPath(box, "");
    }

    public static String createPath(Box box, String str) {
        Container parent = box.getParent();
        int i = 0;
        for (Box box2 : parent.getBoxes()) {
            if (box2.getType().equals(box.getType())) {
                if (box2 == box) {
                    break;
                }
                i++;
            }
        }
        String str2 = String.valueOf(String.format("/%s[%d]", box.getType(), Integer.valueOf(i))) + str;
        if (parent instanceof Box) {
            return createPath((Box) parent, str2);
        }
        return str2;
    }

    public static Box getPath(Box box, String str) {
        List<Box> paths = getPaths(box, str, true);
        if (paths.isEmpty()) {
            return null;
        }
        return paths.get(0);
    }

    public static List<Box> getPaths(Box box, String str) {
        return getPaths(box, str, false);
    }

    public static boolean isContained(Box box, String str) {
        return getPaths(box, str).contains(box);
    }

    public static Box getPath(Container container, String str) {
        List<Box> paths = getPaths(container, str, true);
        if (paths.isEmpty()) {
            return null;
        }
        return paths.get(0);
    }

    public static List<Box> getPaths(Container container, String str) {
        return getPaths(container, str, false);
    }

    public static Box getPath(AbstractContainerBox abstractContainerBox, String str) {
        List<Box> paths = getPaths(abstractContainerBox, str, true);
        if (paths.isEmpty()) {
            return null;
        }
        return paths.get(0);
    }

    public static List<Box> getPaths(AbstractContainerBox abstractContainerBox, String str) {
        return getPaths(abstractContainerBox, str, false);
    }

    public static List<Box> getPaths(Box box, String str, boolean z) {
        return getPaths((Object) box, str, z);
    }

    public static List<Box> getPaths(Container container, String str, boolean z) {
        return getPaths((Object) container, str, z);
    }

    public static List<Box> getPaths(AbstractContainerBox abstractContainerBox, String str, boolean z) {
        return getPaths((Object) abstractContainerBox, str, z);
    }

    public static List<Box> getPaths(Object obj, String str, boolean z) {
        String str2;
        int i;
        if (str.startsWith("/")) {
            String substring = str.substring(1);
            while (obj instanceof Box) {
                obj = ((Box) obj).getParent();
            }
            str = substring;
        }
        if (str.length() == 0) {
            if (obj instanceof Box) {
                return Collections.singletonList((Box) obj);
            }
            throw new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
        }
        int i2 = 0;
        if (str.contains("/")) {
            str2 = str.substring(str.indexOf(47) + 1);
            str = str.substring(0, str.indexOf(47));
        } else {
            str2 = "";
        }
        Matcher matcher = component.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (IStringUtil.TOP_PATH.equals(group)) {
                if (obj instanceof Box) {
                    return getPaths(((Box) obj).getParent(), str2, z);
                }
                return Collections.emptyList();
            } else if (obj instanceof Container) {
                if (matcher.group(2) != null) {
                    i = Integer.parseInt(matcher.group(3));
                } else {
                    i = -1;
                }
                LinkedList linkedList = new LinkedList();
                for (Box box : ((Container) obj).getBoxes()) {
                    if (box.getType().matches(group)) {
                        if (i == -1 || i == i2) {
                            linkedList.addAll(getPaths(box, str2, z));
                        }
                        i2++;
                    }
                    if (z || i >= 0) {
                        if (!linkedList.isEmpty()) {
                            return linkedList;
                        }
                    }
                }
                return linkedList;
            } else {
                return Collections.emptyList();
            }
        }
        throw new RuntimeException(String.valueOf(str) + " is invalid path.");
    }
}
