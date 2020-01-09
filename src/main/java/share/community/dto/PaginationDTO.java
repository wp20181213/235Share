package share.community.dto;

import lombok.Data;
import share.community.model.Question;

import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages;

    public void setPagination(Integer totalCount, Integer offset, Integer size) {
        Integer totalPage = 0;
        if (totalCount % size == 0){
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        showFirstPage = page == 1 ? false : true;
    }
}
