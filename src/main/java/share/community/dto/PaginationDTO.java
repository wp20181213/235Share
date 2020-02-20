package share.community.dto;

import lombok.Data;
import share.community.model.Question;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        if (totalCount % size == 0){
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        totalPage = totalPage < 1 ? 1 : totalPage;

        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页
        showPrevious = page > 1 ? true : false;
        //是否展示下一页
        showNext = page < totalPage ? true : false;
        //是否展示返回第一页
        showFirstPage = pages.contains(1) ? false : true;
        //是否展示返回最后一页
        showEndPage = pages.contains(totalPage) ? false : true;
    }
}
